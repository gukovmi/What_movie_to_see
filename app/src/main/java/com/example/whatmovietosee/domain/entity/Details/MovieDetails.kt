import com.google.gson.annotations.SerializedName


class MovieDetails (

	@SerializedName("adult") val adult : Boolean,
	@SerializedName("backdrop_path") val backdropPath : String?,
	@SerializedName("belongs_to_collection") val belongsToCollection : Object?,
	@SerializedName("budget") val budget : Int,
	@SerializedName("genres") val genres : List<Genres>,
	@SerializedName("homepage") val homepage : String,
	@SerializedName("id") val id : Int,
	@SerializedName("imdb_id") val imdbId : String?,
	@SerializedName("original_language") val originalLanguage : String,
	@SerializedName("original_title") val originalTitle : String,
	@SerializedName("overview") val overview : String?,
	@SerializedName("popularity") val popularity : Double,
	@SerializedName("production_companies") val productionCompanies : List<Production_companies>,
	@SerializedName("production_countries") val productionCountries : List<Production_countries>,
	@SerializedName("release_date") val releaseDate : String,
	@SerializedName("revenue") val revenue : Int,
	@SerializedName("runtime") val runtime : Int?,
	@SerializedName("spoken_languages") val spokenLanguages : List<Spoken_languages>,
	@SerializedName("status") val status : String,
	@SerializedName("tagline") val tagline : String?,
	@SerializedName("title") val title : String,
	@SerializedName("video") val video : Boolean,
	@SerializedName("vote_average") val voteAverage : Double,
	@SerializedName("vote_count") val voteCount : Int
) {
	@SerializedName("poster_path")
	var posterPath: String? = null
		get() = "https://image.tmdb.org/t/p/w500$field"
}