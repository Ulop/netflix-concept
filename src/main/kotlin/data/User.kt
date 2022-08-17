package data

data class User(val name: String, val sureName: String, val avatar: String, val level: Int)

fun getSampleUserData(): User = User("Ramona", "Frederica", "avatars/female.png", 12)