package com.example.moviegames

object Constants {
    fun getQuestion() : ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(1, "How is the first Kazakh film nominated for the Golden Palm wind Cannes Film Festival?" , R.drawable.kelin,
            "Meniń anamnyń armany",
            "Kelin",
            "Shal",
            "Men arqa menimdi súıemin",
            2)

        val que2 = Question(1, "Who played the role of Harley Quinn in the movie Suicide Squad (2016)?" , R.drawable.margot,
            "Scarlett Johansson",
            "Gal Gadot",
            "Margot Robbie",
            "Jennifer Lawrence ",
            3)



        return questionsList
    }
}