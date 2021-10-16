package com.example.applicationcurriculumvitaev2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox

private const val ARG_MUSIC = "Music"
private const val ARG_SPORT = "Sport"
private const val ARG_GAMES = "Games"

class hobbies : Fragment() {

    private var musicState = false
    private var sportState = false
    private var gamesState = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            musicState = it.getBoolean(ARG_MUSIC)
            sportState = it.getBoolean(ARG_SPORT)
            gamesState = it.getBoolean(ARG_GAMES)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_hobbies, container, false)
        // Inflate the layout for this fragment
        val CB_Music = view.findViewById<CheckBox>(R.id.checkBox_music)
        val CB_Sport = view.findViewById<CheckBox>(R.id.checkBox_sport)
        val CB_Games = view.findViewById<CheckBox>(R.id.checkBox_game)
        /**
         * Condition to get multiple boxes when checked
         */
        if (arguments != null) {
            if ((arguments?.getBoolean(ARG_MUSIC) == true) && ((arguments?.getBoolean(ARG_SPORT) == true)) && (arguments?.getBoolean(
                    ARG_GAMES
                ) == true)
            ) {
                true.let {
                    musicState = it
                    sportState = it
                    gamesState = it
                }
                CB_Music.isChecked = musicState
                CB_Sport.isChecked = sportState
                CB_Games.isChecked = gamesState
            } else if ((arguments?.getBoolean(ARG_MUSIC) == true) && ((arguments?.getBoolean(
                    ARG_SPORT
                ) == true) && (arguments?.getBoolean(ARG_GAMES))==false)
            ) {
                true.let {
                    musicState = it
                    sportState = it
                }
                gamesState = false
                CB_Music.isChecked = musicState
                CB_Sport.isChecked = sportState
                CB_Games.isChecked = gamesState
            } else if ((arguments?.getBoolean(ARG_MUSIC) == true) && ((arguments?.getBoolean(
                    ARG_SPORT
                ) == false)) && (arguments?.getBoolean(ARG_GAMES)==true)
            ) {
                true.let {
                    musicState = it
                    gamesState = it

                }
                sportState= false
                CB_Music.isChecked = musicState
                CB_Sport.isChecked = sportState
                CB_Games.isChecked = gamesState
            }else if ((arguments?.getBoolean(ARG_MUSIC) == false) && ((arguments?.getBoolean(
                    ARG_SPORT
                ) == true)) && (arguments?.getBoolean(ARG_GAMES)==true)
            ) {
                true.let {
                    sportState= it
                    gamesState = it

                }
                musicState= false
                CB_Music.isChecked = musicState
                CB_Sport.isChecked = sportState
                CB_Games.isChecked = gamesState
            } else if (arguments?.getBoolean(ARG_GAMES) == true) {
                gamesState = true
                CB_Games.isChecked = gamesState
            }else if (arguments?.getBoolean(ARG_MUSIC) == true) {
                musicState = true
                CB_Music.isChecked = gamesState
            }else if (arguments?.getBoolean(ARG_SPORT) == true) {
                sportState = true
                CB_Sport.isChecked = gamesState
            } else {
                CB_Music.isChecked = false
                CB_Sport.isChecked = false
                CB_Games.isChecked = false

            }
        }
        /**
         * Disable cheking
         */
        CB_Games.setOnTouchListener { _, _ -> true  }
        CB_Sport.setOnTouchListener { _, _ -> true  }
        CB_Music.setOnTouchListener { _, _ -> true  }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment test.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Boolean?, param2: Boolean?, param3: Boolean?) =
            hobbies().apply {
                arguments = Bundle().apply {
                    param1?.let { putBoolean(ARG_MUSIC, it) }
                    param2?.let { putBoolean(ARG_SPORT, it) }
                    param3?.let { putBoolean(ARG_GAMES, it) }

                }
            }
    }


}