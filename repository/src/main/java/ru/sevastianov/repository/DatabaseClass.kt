package ru.sevastianov.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.sevastianov.repository.dao.EventDao
import ru.sevastianov.repository.dao.GroupDao
import ru.sevastianov.repository.dao.InterestDao
import ru.sevastianov.repository.dao.TagDao
import ru.sevastianov.repository.dao.TagEventDao
import ru.sevastianov.repository.dao.TagGroupDao
import ru.sevastianov.repository.dao.UserDao
import ru.sevastianov.repository.dao.UserEventDao
import ru.sevastianov.repository.dao.UserGroupDao
import ru.sevastianov.repository.entities.EventEntity
import ru.sevastianov.repository.entities.GroupEntity
import ru.sevastianov.repository.entities.MytInterestEntity
import ru.sevastianov.repository.entities.TagEntity
import ru.sevastianov.repository.entities.TagsEventsCrossRef
import ru.sevastianov.repository.entities.TagsGroupsCrossRef
import ru.sevastianov.repository.entities.UserEntity
import ru.sevastianov.repository.entities.UsersEventsCrossRef
import ru.sevastianov.repository.entities.UsersGroupsCrossRef


@Database(
    entities = [EventEntity::class,
        GroupEntity::class, TagEntity::class, MytInterestEntity::class,
        TagsEventsCrossRef::class, TagsGroupsCrossRef::class,
        UserEntity::class, UsersEventsCrossRef::class,
        UsersGroupsCrossRef::class], version = 1, exportSchema = false
)
abstract class DatabaseClass : RoomDatabase() {

    abstract fun eventDao(): EventDao
    abstract fun groupDao(): GroupDao
    abstract fun tagDao(): TagDao
    abstract fun userDao(): UserDao
    abstract fun interestDao(): InterestDao
    abstract fun tagEventDao(): TagEventDao
    abstract fun tagGroupDao(): TagGroupDao
    abstract fun userGroupDao(): UserGroupDao
    abstract fun userEventDao(): UserEventDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: DatabaseClass? = null

        fun getDatabase(context: Context, scope: CoroutineScope): DatabaseClass {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseClass::class.java,
                    "party_database"
                )
                    //.createFromAsset("receipt_database")  // to create db with my data
                    .addCallback(DatabaseClassCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }


        private class DatabaseClassCallback(private val scope: CoroutineScope) : Callback() {
            /**
             * Override the onCreate method to populate the database.
             */
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateTags(database.tagDao())
                        populateUsers(database.userDao())
                        populateGroups(database.groupDao())
                        populateEvents(database.eventDao())

                        populateTagEvents(database.tagEventDao())
                        populateTagGroups(database.tagGroupDao())
                        populateUserEvents(database.userEventDao())
                        populateUserGroups(database.userGroupDao())

                    }
                }
            }
        }

        suspend fun populateGroups(groupDao: GroupDao) {
            val group1 = GroupEntity(
                groupId = 1L,
                name = "The IT Crowd",
                description = "Сообщество профессионалов в сфере IT. Объединяем специалистов разных направлений для обмена опытом, знаниями и идеями.",
                logoUrl = "https://live.staticflickr.com/65535/54009421916_ea4ef543bd_o.png",
                subscribed = false
            )
            val group2 = GroupEntity(
                groupId = 2L,
                name = "Супер тестировщики",
                description = "Группа про проведение тестов ЕГЭ ;))",
                logoUrl = "https://live.staticflickr.com/65535/53938319895_7de2e7b500_o.png",
                subscribed = true
            )
            groupDao.insert(group1)
            groupDao.insert(group2)
        }

        suspend fun populateEvents(groupDao: EventDao) {
            val event1 = EventEntity(
                eventId = 1,
                dateUnix = 1734294958,
                name = "Как повышать грейд. Лекция Павла Хорикова",
                description = "Узнайте, как расти в профессии, улучшать навыки и получать повышение. Практические советы и реальные кейсы.\n" +
                        "Павел поделится эффективными стратегиями карьерного роста и методикой развития профессиональных навыков в IT.",
                freeSpaces = 30,
                place = "Севкабель Порт, Кожевенная линия, 40, ",
                metroName = "Hollywood",
                logoUrl = "https://live.staticflickr.com/65535/53937001403_90412c258b_o.png",
                iGo = true,
                isBig = true,
                lat = 55.0,
                lon = 60.0,
                speakerName = "Павел Хориков",
                speakerDescription = "Ведущий специалист поподбору персонала в одной изкрупнейших IT-компаний вЕС.",
                speakerImgUrl = "https://live.staticflickr.com/65535/54025761414_ab1686ca88_o.png",
                groupId = 1L
            )

            val event2 = EventEntity(
                eventId = 2L, dateUnix = 1737146158, name = "Андроидкор QA 2024",
                description = "Описание Андроидкор",
                freeSpaces = 777,
                groupId = 1L,
                iGo = false, isBig = true,
                lat = 55.0, lon = 60.0,
                logoUrl = "https://live.staticflickr.com/65535/54024536542_4c77b540fc_o.png",
                place = "Бункер 703",
                metroName = "Павелецкая",
                speakerImgUrl = "https://live.staticflickr.com/65535/54025890020_1f7ae036d8_o.png",
                speakerName = "John Doe",
                speakerDescription = "Мы сами её первый раз видим :)))"
            )

            val event3 = EventEntity(
                eventId = 3L, dateUnix = 1696350491, name = "Python days 2024",
                description = "Питонячьи дни",
                freeSpaces = 666,
                groupId = 2L,
                iGo = false, isBig = false,
                lat = 55.0, lon = 60.0,
                logoUrl = "https://live.staticflickr.com/65535/54024558407_a9b2aceb38_o.png",
                place = "Бункер 703",
                metroName = "Павелецкая",
                speakerImgUrl = "https://live.staticflickr.com/65535/54025696088_a7eff6e24b_o.png",
                speakerName = "John Doe",
                speakerDescription = "Мы сами её первый раз видим :)))"
            )

            val event4 = EventEntity(
                eventId = 4L, dateUnix = 1734567758, name = "Событие 4",
                description = "Питонячьи дни 2",
                freeSpaces = 12,
                groupId = 1L,
                iGo = false, isBig = false,
                lat = 55.0, lon = 60.0,
                logoUrl = "https://live.staticflickr.com/65535/54024558407_a9b2aceb38_o.png",
                place = "Бункер 703",
                metroName = "Павелецкая",
                speakerImgUrl = "https://live.staticflickr.com/65535/54025696088_a7eff6e24b_o.png",
                speakerName = "John Doe",
                speakerDescription = "Мы сами её первый раз видим 2 :)))"
            )

            groupDao.insert(event1)
            groupDao.insert(event2)
            groupDao.insert(event3)
            groupDao.insert(event4)
        }

        suspend fun populateTags(tagDao: TagDao) {
            tagDao.insert(TagEntity(tagId = 1L, nameTag = "Тестирование"))
            tagDao.insert(TagEntity(tagId = 2L, nameTag = "Разработка"))
            tagDao.insert(TagEntity(tagId = 3L, nameTag = "Backend"))
            tagDao.insert(TagEntity(tagId = 4L, nameTag = "Маркетинг"))
            tagDao.insert(TagEntity(tagId = 5L, nameTag = "Бизнес"))
            tagDao.insert(TagEntity(tagId = 6L, nameTag = "Продажи"))
            tagDao.insert(TagEntity(tagId = 7L, nameTag = "Карьера"))
            tagDao.insert(TagEntity(tagId = 8L, nameTag = "Дизайн"))
            tagDao.insert(TagEntity(tagId = 9L, nameTag = "Продакт"))
        }

        suspend fun populateUsers(userDao: UserDao) {
            userDao.insert(
                UserEntity(
                    userId = 1L, name = "Анастасия", tagId = 8L,
                    avatarUrl = "https://live.staticflickr.com/65535/54025827574_bb4e07f69e_o.png"
                )
            )
            userDao.insert(
                UserEntity(
                    userId = 2L, name = "Артём", tagId = 5L,
                    avatarUrl = "https://live.staticflickr.com/65535/54025942710_83c6689906_o.png"
                )
            )
            userDao.insert(
                UserEntity(
                    userId = 3L, name = "Ирина", tagId = 2L,
                    avatarUrl = "https://live.staticflickr.com/65535/54025833724_cc2130e9a2_o.png"
                )
            )
            userDao.insert(
                UserEntity(
                    userId = 4L, name = "Никита", tagId = 9L,
                    avatarUrl = "https://live.staticflickr.com/65535/54025948665_fddb16eea0_o.png"
                )
            )
            userDao.insert(
                UserEntity(
                    userId = 5L, name = "Яков", tagId = 2L,
                    avatarUrl = "https://live.staticflickr.com/65535/54024612187_3d88c59e63_o.png"
                )
            )
            userDao.insert(
                UserEntity(
                    userId = 6L, name = "Ексей", tagId = 2L,
                    avatarUrl = "https://live.staticflickr.com/65535/54025954510_acc4b77146_o.png"
                )
            )
            userDao.insert(
                UserEntity(
                    userId = 7L, name = "Алёнка", tagId = 8L,
                    avatarUrl = "https://ciarf.ru/upload/medialibrary/cc9/cc99169cf64653b7d49d08433a6d9724.jpg"
                )
            )
        }

        suspend fun populateTagEvents(tagEventDao: TagEventDao) {
            tagEventDao.insert(TagsEventsCrossRef(tagId = 4L, eventId = 1L))
            tagEventDao.insert(TagsEventsCrossRef(tagId = 5L, eventId = 1L))
            tagEventDao.insert(TagsEventsCrossRef(tagId = 6L, eventId = 1L))

            tagEventDao.insert(TagsEventsCrossRef(tagId = 1L, eventId = 2L))
            tagEventDao.insert(TagsEventsCrossRef(tagId = 3L, eventId = 2L))

            tagEventDao.insert(TagsEventsCrossRef(tagId = 2L, eventId = 3L))
            tagEventDao.insert(TagsEventsCrossRef(tagId = 1L, eventId = 3L))
        }

        suspend fun populateTagGroups(tagGroupDao: TagGroupDao) {
            tagGroupDao.insert(TagsGroupsCrossRef(tagId = 2L, groupId = 1L))
            tagGroupDao.insert(TagsGroupsCrossRef(tagId = 7L, groupId = 1L))
            tagGroupDao.insert(TagsGroupsCrossRef(tagId = 1L, groupId = 1L))
            tagGroupDao.insert(TagsGroupsCrossRef(tagId = 8L, groupId = 1L))
            tagGroupDao.insert(TagsGroupsCrossRef(tagId = 5L, groupId = 1L))

            tagGroupDao.insert(TagsGroupsCrossRef(tagId = 1L, groupId = 2L))
            tagGroupDao.insert(TagsGroupsCrossRef(tagId = 3L, groupId = 2L))
        }

        suspend fun populateUserEvents(userEventDao: UserEventDao) {
            userEventDao.insert(UsersEventsCrossRef(userId = 1L, eventId = 1L))
            userEventDao.insert(UsersEventsCrossRef(userId = 2L, eventId = 1L))
            userEventDao.insert(UsersEventsCrossRef(userId = 3L, eventId = 1L))
            userEventDao.insert(UsersEventsCrossRef(userId = 7L, eventId = 1L))

            userEventDao.insert(UsersEventsCrossRef(userId = 2L, eventId = 2L))
            userEventDao.insert(UsersEventsCrossRef(userId = 3L, eventId = 2L))
            userEventDao.insert(UsersEventsCrossRef(userId = 4L, eventId = 2L))
            userEventDao.insert(UsersEventsCrossRef(userId = 5L, eventId = 2L))

            userEventDao.insert(UsersEventsCrossRef(userId = 4L, eventId = 3L))
            userEventDao.insert(UsersEventsCrossRef(userId = 5L, eventId = 3L))
            userEventDao.insert(UsersEventsCrossRef(userId = 6L, eventId = 3L))
            userEventDao.insert(UsersEventsCrossRef(userId = 7L, eventId = 3L))
        }

        suspend fun populateUserGroups(userGroupDao: UserGroupDao) {
            userGroupDao.insert(UsersGroupsCrossRef(userId = 1L, groupId = 1))
            userGroupDao.insert(UsersGroupsCrossRef(userId = 2L, groupId = 1))
            userGroupDao.insert(UsersGroupsCrossRef(userId = 3L, groupId = 1))
            userGroupDao.insert(UsersGroupsCrossRef(userId = 4L, groupId = 1))

            userGroupDao.insert(UsersGroupsCrossRef(userId = 3L, groupId = 2))
            userGroupDao.insert(UsersGroupsCrossRef(userId = 4L, groupId = 2))
            userGroupDao.insert(UsersGroupsCrossRef(userId = 5L, groupId = 2))
            userGroupDao.insert(UsersGroupsCrossRef(userId = 5L, groupId = 2))
            userGroupDao.insert(UsersGroupsCrossRef(userId = 7L, groupId = 2))
        }

    }

}