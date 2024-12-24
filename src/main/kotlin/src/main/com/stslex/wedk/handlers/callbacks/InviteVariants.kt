package src.main.com.stslex.wedk.handlers.callbacks

enum class InviteVariants(
    val callbackName: String,
    val variantName: String
) {
    INVITE_YES("invite_yes", "Да"),
    INVITE_NO("invite_no", "Нет"),
}