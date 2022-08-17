package data

data class User(val name: String, val sureName: String, val avatar: String, val level: Int)

fun getSampleUserData(): User = User("Ramona", "Frederica", "avatars/female.png", 12)

fun getSampleUsersData(): List<User> = buildList {
    add(User("Wilma", "Wilson", "avatars/wilma_wilson.jpg", 12))
    add(User("Arlene", "Schmidt", "avatars/arlene_schmidt.jpg", 12))
    add(User("Andre", "Vasquez", "avatars/andrea_vasquez.jpg", 12))
    add(User("Constance", "Snyder", "avatars/constance_snyder.jpg", 12))
    add(User("Marjorie", "Pena", "avatars/marjorie_pena.jpg", 12))
    add(User("Alyssa", "Dixon", "avatars/alyssa_dixon.jpg", 12))
    add(User("Jimmie", "Welch", "avatars/ji", 12))
}