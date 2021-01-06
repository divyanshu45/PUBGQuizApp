package com.example.quizapp

object Constants{
    const val USER_NAME: String = "USERNAME"
    const val TOTAL_QUES: String = "TOTAL QUESTIONS"
    const val CORRECT_ANS: String = "CORRECT_ANSWER"

    fun getQuestion(): ArrayList<Ques>{
        val quesList = ArrayList<Ques>()

        val ques1 = Ques(1,
            "Which gun is this?",
            R.drawable.scarl,
            false,
            "SCAR-L",
            "M416",
            "M762",
            "AKM",
            1)

        val ques2 = Ques(2,
            "Which gun is this?",
            R.drawable.gc,
            false,
            "PP-BISON",
            "UMP-45",
            "G36C",
            "VSS",
            3)

        val ques3 = Ques(3,
            "Which gun is this?",
            R.drawable.win,
            false,
            "WIN-94",
            "S686",
            "S1897",
            "KAR98-K",
            1)

        val ques4 = Ques(4,
                "Which gun is this?",
                R.drawable.crossbow,
                false,
                "AWM",
                "M24",
                "CROSSBOW",
                "KAR98-K",
                3)

        val ques5 = Ques(5,
                "Which gun is this?",
                R.drawable.slr,
                false,
                "SKS",
                "SLR",
                "MINI-14",
                "KAR98-K",
                2)

        val ques6 = Ques(6,
                "Which gun is this?",
                R.drawable.r1895,
                false,
                "SCORPION",
                "P1911",
                "P92",
                "R1895",
                4)

        val ques7 = Ques(7,
                "Which gun is this?",
                R.drawable.qbz,
                false,
                "M416",
                "QBZ",
                "M762",
                "SCAR-L",
                2)

        val ques8 = Ques(8,
                "Which gun is this?",
                R.drawable.qbu,
                false,
                "SKS",
                "SLR",
                "MK14",
                "QBU",
                4)

        val ques9 = Ques(9,
                "Which gun is this?",
                R.drawable.p1911,
                false,
                "P92",
                "SCORPION",
                "P1911",
                "DESERT EAGLE",
                3)

        val ques10 = Ques(10,
                "Which gun is this?",
                R.drawable.s686,
                false,
                "DBS",
                "WIN-94",
                "S1897",
                "S686",
                4)


        quesList.add(ques1)
        quesList.add(ques2)
        quesList.add(ques3)
        quesList.add(ques4)
        quesList.add(ques5)
        quesList.add(ques6)
        quesList.add(ques7)
        quesList.add(ques8)
        quesList.add(ques9)
        quesList.add(ques10)

        quesList.shuffle()
        return quesList

    }

    fun getCards() : ArrayList<Card>{
        val cards = ArrayList<Card>()

        val card1 = Card("WEAPON IMAGES",
                "Guess the Images",
                R.drawable.bg)

        val card2 = Card("OTHERS",
                "Guess the other materials",
                R.drawable.bg1)

        cards.add(card1)
        cards.add(card2)

        return cards
    }

    fun getOtherQues() : ArrayList<Ques>{
        val quesList = ArrayList<Ques>()

        val ques1 = Ques(1,
            "What is the level of this Helmet?",
            R.drawable.helmet,
            false,
            "LEVEL 2",
            "LEVEL 3",
            "LEVEL 1",
            "LEVEL 4",
            2)

        val ques2 = Ques(2,
                "Which throwable is this?",
                R.drawable.stung,
                false,
                "FRAG GRENADE",
                "SMOKE GRENADE",
                "STUNG GRENADE",
                "MONOTOV COCKTAIL",
                3)

        val ques3 = Ques(3,
                "Which weapon is this?",
                R.drawable.sickle,
                false,
                "SICKLE",
                "PAN",
                "PISTOL",
                "SNIPER",
                1)

        val ques4 = Ques(4,
                "What is the level of this vest?",
                R.drawable.vest,
                false,
                "LEVEL 2",
                "LEVEL 3",
                "LEVEL 4",
                "LEVEL 1",
                4)

        val ques5 = Ques(5,
                "Which healing material is this?",
                R.drawable.adrenaline,
                false,
                "PAIN KILLER",
                "MED-KIT",
                "ADRENALINE",
                "ENERGY DRINK",
                3)

        val ques6 = Ques(6,
                "In which gun this stock is used?",
                R.drawable.stock,
                false,
                "M416",
                "UZI",
                "VECTOR",
                "UMP45",
                2)

        val ques7 = Ques(7,
                "What is the level of this bag?",
                R.drawable.bag,
                false,
                "LEVEL 2",
                "LEVEL 3",
                "LEVEL 1",
                "LEVEL 4",
                1)

        val ques8 = Ques(8,
                "In which gun this ammonation is used?",
                R.drawable.ammo,
                false,
                "KAR98K",
                "WIN-94",
                "M24",
                "AWM",
                4)

        val ques9 = Ques(9,
                "Which vehicle is this?",
                R.drawable.buggy,
                false,
                "DACIA",
                "BUGGY",
                "UAZ",
                "MOTOR BIKE",
                2)

        val ques10 = Ques(10,
                "Which attachment is this?",
                R.drawable.compensator,
                false,
                "FLASH HIDER",
                "SUPRESSOR",
                "COMPENSATOR",
                "MUZZLE",
                3)

        quesList.add(ques1)
        quesList.add(ques2)
        quesList.add(ques3)
        quesList.add(ques4)
        quesList.add(ques5)
        quesList.add(ques6)
        quesList.add(ques7)
        quesList.add(ques8)
        quesList.add(ques9)
        quesList.add(ques10)

        quesList.shuffle()
        return quesList
    }

    fun getRandomQues() : ArrayList<Ques>{
        val randomList = ArrayList<Ques>()
        for(i in 1..5){
            val random = getQuestion().random()
            randomList.add(random)
        }
        for(i in 1..5){
            val random = getOtherQues().random()
            randomList.add(random)
        }
        randomList.shuffle()
        return randomList
    }
}