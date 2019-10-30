package dev.sasikanth.epoxysample

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.carousel
import dev.sasikanth.epoxysample.data.Message
import dev.sasikanth.epoxysample.data.Profile

class HomeController : AsyncEpoxyController() {

    var recentlyActive: List<Profile> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }
    var allMessages: List<Message> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        headerItem {
            id("recently_active")
            title("Recently Active")
        }
        val models = recentlyActive.map {
            RecentlyActiveItemModel_()
                .id(it.id)
                .profile(it)
        }
        carousel {
            id("recent")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(models)
        }

        headerItem {
            id("all_messages")
            title("All Messages")
        }
        allMessages.forEach {
            messageItem {
                id(it.id)
                message(it)
            }
        }
    }
}