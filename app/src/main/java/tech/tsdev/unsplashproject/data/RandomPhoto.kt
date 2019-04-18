package tech.tsdev.unsplashproject.data

data class RandomPhoto(
    val alt_description: String,
    val categories: List<Any>,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>,
    val description: Any,
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