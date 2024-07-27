package ru.sevastianov.domain.usecases

// условная проверка урла, что в нём есть http либо https, а также точка и что-то после неё
val urlRegex = Regex("""^https?://.+\..+""")

// "проверка" номера телефона - сначала "+" потом 11 или более цифр
val phoneRegex = Regex("""^\+\d{11,}$""")