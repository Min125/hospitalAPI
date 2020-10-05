package coder.mtk.typicoderetrofit.model

data class HospitalXX(
    val email: String,
    val facebook_link: String,
    val hospital_banner: String,
    val hospital_id: Int,
    val hospital_image: String,
    val hospital_name: String,
    val phone_no: String,
    val place: String,
    val specialities: List<SpecialityX>,
    val website_link: String
)