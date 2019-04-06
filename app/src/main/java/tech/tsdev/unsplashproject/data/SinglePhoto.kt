package tech.tsdev.unsplashproject.data

data class SinglePhoto(
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
    val photo_tags: List<PhotoTag>,
    val related_collections: RelatedCollections,
    val sponsored: Boolean,
    val sponsored_by: Any,
    val sponsored_impressions_id: Any,
    val story: Story,
    val tags: List<Tag>,
    val updated_at: String,
    val urls: Urls,
    val user: User,
    val views: Int,
    val width: Int
)


data class Story(
    val description: Any,
    val title: Any
)


data class Exif(
    val aperture: String,
    val exposure_time: String,
    val focal_length: String,
    val iso: Int,
    val make: String,
    val model: String
)

data class RelatedCollections(
    val results: List<Result>,
    val total: Int,
    val type: String
)



data class PreviewPhoto(
    val id: String,
    val urls: Urls
)




data class LinksXX(
    val followers: String,
    val following: String,
    val html: String,
    val likes: String,
    val photos: String,
    val portfolio: String,
    val self: String
)

data class CoverPhoto(
    val alt_description: String,
    val categories: List<Any>,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>,
    val description: Any,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: Links,
    val sponsored: Boolean,
    val sponsored_by: Any,
    val sponsored_impressions_id: Any,
    val updated_at: String,
    val urls: Urls,
    val user: UserX,
    val width: Int
)

data class UserX(
    val accepted_tos: Boolean,
    val bio: Any,
    val first_name: String,
    val id: String,
    val instagram_username: String,
    val last_name: String,
    val links: Links,
    val location: String,
    val name: String,
    val portfolio_url: String,
    val profile_image: ProfileImage,
    val total_collections: Int,
    val total_likes: Int,
    val total_photos: Int,
    val twitter_username: Any,
    val updated_at: String,
    val username: String
)