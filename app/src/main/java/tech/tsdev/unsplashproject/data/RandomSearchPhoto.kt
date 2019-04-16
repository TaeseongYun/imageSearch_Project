package tech.tsdev.unsplashproject.data

data class RandomSearchPhoto(
    val alt_description: String,
    val categories: List<Any>,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>,
    val description: String,
    val downloads: Int,
    val exif: Exif,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: Links,
    val location: Location,
    val sponsored: Boolean,
    val sponsored_by: Any,
    val sponsored_impressions_id: Any,
    val updated_at: String,
    val urls: Urls,
    val user: User,
    val views: Int,
    val width: Int
)

data class Location(
    val city: Any,
    val country: String,
    val name: String,
    val position: Position,
    val title: String
)

data class Position(
    val latitude: Double,
    val longitude: Double
)
