package ru.sevastianov.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.sevastianov.domain.models.Group
import ru.sevastianov.domain.repository.IEventsRepository

class GetAllGroups(val repository: IEventsRepository) : IGetAllGroups {

    override fun execute(): Flow<List<Group>> {
        return flowOf(mockGroups)
    }

    private val mockGroups = listOf(
        Group(name = "Linux", numberPerson = 12, imgUrl = "https://live.staticflickr.com/65535/53844284150_5c59f30792_o_d.png"),
        Group(name = "Группа 2", numberPerson = 3, imgUrl = "https://slm-assets.secondlife.com/assets/3789225/lightbox/512x512%20PNG%20Landscape%20Texture%20-%20Country%20Lane.jpg?1308962600"),
        Group(name = "Сходка 1", numberPerson = 21, imgUrl = "https://slm-assets.secondlife.com/assets/3806158/view_large/512x512%20PNG%20Landscape%20Texture%20-%20Sunrise%20Lake.jpg?1309205114"),
        Group(name = "Designa", numberPerson = 10000, imgUrl = "https://live.staticflickr.com/65535/53844225160_805136ae16_o_d.jpg"),
        Group(name = "Designa", numberPerson = 10000, imgUrl = "https://live.staticflickr.com/65535/53844225160_805136ae16_o_d.jpg"),
        Group(name = "Designa", numberPerson = 10000, imgUrl = "https://live.staticflickr.com/65535/53844225160_805136ae16_o_d.jpg"),
        Group(name = "Designa", numberPerson = 10000, imgUrl = "https://live.staticflickr.com/65535/53844225160_805136ae16_o_d.jpg"),
        Group(name = "Designa", numberPerson = 10000, imgUrl = "https://live.staticflickr.com/65535/53844225160_805136ae16_o_d.jpg")
    )

}

interface IGetAllGroups {
    fun execute(): Flow<List<Group>>
}