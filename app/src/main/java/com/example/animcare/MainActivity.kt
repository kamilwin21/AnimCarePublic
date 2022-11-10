package com.example.animcare

import android.annotation.SuppressLint
import android.app.ActionBar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.animcare.Classes.*
import com.example.animcare.DatabaseFiles.DataBase
import com.example.animcare.Dogs.CavalierKingCharlesSpaniel
import com.example.animcare.MainActivityFiles.Fragments.*
import com.example.animcare.MainActivityFiles.MyPets.Class.CustomDateAndTime
import com.example.animcare.MainActivityFiles.MyPets.Class.Diagnosis
import com.example.animcare.MainActivityFiles.MyPets.Fragments.PetsFragment
import com.example.animcare.MainActivityFiles.MyPets.petsUser
import com.example.animcare.Quizzes.Cats
import com.example.animcare.Quizzes.Dogs
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.type.DateTime
import kotlinx.android.synthetic.main.nav_header.*
import java.time.LocalDate
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.ResolverStyle
import java.util.*

class MainActivity : AppCompatActivity() {

    val didacticsFragment = DidacticsFragment()
    val quizFragment = QuizFragment()
    val optionFragment = OptionFragment()
    val accountFragment = AccountFragment()
    val diseaseDetectionFragment = DiseaseDetectionFragment()
    @RequiresApi(Build.VERSION_CODES.O)
    val petsFragment = PetsFragment()
    //Connection from database auth
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    //=================================================================================
    //Navigation on the left screen
    //=================================================================================
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView






    val dog = Dog(
        "Owczarek szetlandzki",
        "https://firebasestorage.googleapis.com/v0/b/animcare-ea72d.appspot.com/o/szelk.png?alt=media&token=2a758ee6-ff9c-46b4-90e4-3c9bfac90223",
        "Wesoły, żywy, energiczny i skory do zabawy; nieufny wobec obcych, oddany właścicielowi",
        "5-10kg",
        "śniade, śniade z białym, marmurkowe, czarne podpalane z białymi znaczeniami, czarne podpalane",
        "psy - 34,5-39,5 cm, suki - 33,5-38,5 cm",
        "Szkocja",
        "12 do 13 lat",
        CustomText(
            "OwczarekSzetlandzki",
            arrayListOf(
                Section("0", "Pielęgnacja",
                    arrayListOf(
                        Paragraph("0", "image",
                                ImageLocalization("https://firebasestorage.googleapis.com/v0/b/animcare-ea72d.appspot.com/o/pielegnacja1.png?alt=media&token=88394751-d88d-4d6f-9617-6aaccee6fd92"),
                            "null"
                            ),
                        Paragraph("1", "text",
                            ImageLocalization(),
                            "Długa sierść i gęsty podszerstek sprawiają, że owczarek szetlandzki jest rasą, " +
                                    "która potrzebuje dosyć intensywnej pielęgnacji. " +
                                    "Wprawdzie nie jest to proceder tak wymagający, jak w przypadku dużych ras, " +
                                    "ale mimo wszystko wymaga regularnego szczotkowania. Sheltie linieje dwa razy w roku, " +
                                    "jednak niektóre osobniki mogą gubić sierść nawet przez cały rok. " +
                                    "Regularne czesanie jest ważne, ponieważ pozwala na usuwanie martwego włosia na bieżąco."
                        ),
                        Paragraph("2", "text",
                        ImageLocalization(),
                            "Po intensywnym spacerze, podczas którego pies ma szansę ubrudzić się błotem, " +
                                    "warto go wykąpać a następnie dokładnie wysuszyć."
                        ),
                        Paragraph("3", "text",
                            ImageLocalization(),
                            "W przypadku rasy owczarek szetlandzki żywienie nie musi odbiegać od " +
                                    "jadłospisu innych małych psów. Sheltie mają pewną skłonność do tycia, " +
                                    "dlatego warto zapewnić im wysokiej jakości karmę bogatą w białko i ubogą w " +
                                    "węglowodany. Dobrym rozwiązaniem będzie także dieta BARF oparta na " +
                                    "surowym mięsie i indywidualnie dobranych suplementach. " +
                                    "Kluczem do zachowania dobrej sylwetki jest aktywność fizyczna i unikanie " +
                                    "dokarmiania psa pomiędzy posiłkami. Żywienie owczarka szetlandzkiego " +
                                    "powinno być dobrze zaplanowane i zrównoważone."
                        )


                    )


                ),
                Section("1", "Hodowla",
                    arrayListOf(
                        Paragraph("0", "image",
                        ImageLocalization("https://firebasestorage.googleapis.com/v0/b/animcare-ea72d.appspot.com/o/hodowla2.png?alt=media&token=f9b5e9fb-6d6c-4c5f-a57f-0f20a1223d0e"),
                            "null"
                        ),
                        Paragraph("1", "text", ImageLocalization(),
                            "Owczarek szetlandzki jest coraz bardziej popularną rasą w naszym kraju, " +
                                    "dlatego z każdym rokiem pojawia się coraz więcej nowych hodowli. " +
                                    "Niestety, tak jak w przypadku wszystkich ras, które zyskują na popularności, " +
                                    "jest to prawdziwa pożywka dla pseudohodowców. Właśnie dlatego, " +
                                    "zanim jeszcze zaczniesz szukać szczeniaka, zapamiętaj, " +
                                    "aby wybierać tylko te hodowle, które są zarejestrowane " +
                                    "w Związku Kynologicznym w Polsce."
                            )

                    )
                    ),
                Section("2", "Cena",
                    arrayListOf(
                        Paragraph("0", "text", ImageLocalization(),
                        "Znalezienie hodowli psów tej rasy nie jest obecnie szczególnie trudne. " +
                                "Cena owczarka szetlandzkiego wynosi od dwóch do czterech tysięcy złotych. " +
                                "Warto jednak zaznaczyć, że jest ona zawsze ustalana indywidualnie przez hodowcę. "
                        ),
                        Paragraph("1", "text", ImageLocalization(),
                        "Szczególnie popularne w ostatnim czasie jest umaszczenie blue merle. " +
                                "Takie pieski są też najdroższe. Poszukując szczeniaka, " +
                                "kieruj się jednak jego charakterem, a nie wyglądem. " +
                                "O tym, jaki szczeniak najbardziej pasuje do twojej rodziny, " +
                                "dowiesz się od hodowcy. "
                        )


                    )
                    )


            )




        )

    )







    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)










//        var savePetsUser = FirebaseDatabase.getInstance(DataBase.dbReferName).reference
//        savePetsUser.child("UsersPets").child(FirebaseAuth.getInstance().currentUser!!.uid)
//            .setValue(petsUser.pets)


        auth = Firebase.auth
        auth.signInWithEmailAndPassword("kamil@gmail.com", "123456789")
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(applicationContext, "Successed Login", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(applicationContext, "Failed Login", Toast.LENGTH_SHORT).show()
                }
            }


        var db = FirebaseDatabase.getInstance(DataBase.dbReferName).reference
        db.child("Dogs").child(CavalierKingCharlesSpaniel.cavalierKingCharlesSpaniel.race).setValue(CavalierKingCharlesSpaniel.cavalierKingCharlesSpaniel)

        var dbQuiz = FirebaseDatabase.getInstance(DataBase.dbReferName).reference
        dbQuiz.child("Quizzes").child(Dogs.psy.quizName).setValue(Dogs.psy)
        dbQuiz.child("Quizzes").child(Cats.cats.quizName).setValue(Cats.cats)
        drawerLayout = findViewById(R.id.drawerLayout)
        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(actionBarToggle)

        goToFragment(didacticsFragment)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        actionBarToggle.syncState()

        navView = findViewById(R.id.navView)





        navView.setNavigationItemSelectedListener { menuItem ->


            when (menuItem.itemId){
                R.id.firstOption -> {
                    goToFragment(didacticsFragment)
                    closeNavigationDrawer(this.drawerLayout)
                    true
                }
                R.id.myPets -> {
                    goToFragment(petsFragment)
                    closeNavigationDrawer(this.drawerLayout)



                    true
                }

                R.id.SecondOption -> {
                    goToFragment(quizFragment)
//                    database = FirebaseDatabase.getInstance(DataBase.dbReferName).reference
//                    database.setValue("Normalna notka")
                    closeNavigationDrawer(this.drawerLayout)
                    true
                }
                R.id.thirdOption -> {
                    goToFragment(diseaseDetectionFragment)
                    closeNavigationDrawer(this.drawerLayout)
                    true
                }
                R.id.fourthOption -> {

                    closeNavigationDrawer(this.drawerLayout)
                    true
                }
                else -> {
                    false
                }

            }



        }





    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.other_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.faq -> {
                Toast.makeText(applicationContext, "FAQ", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> {
                super.onOptionsItemSelected(item)

            }

        }
        return false
    }

    override fun onSupportNavigateUp(): Boolean {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(navView)
        }else{
            drawerLayout.openDrawer(navView)
        }


        return true
    }


    @SuppressLint("WrongConstant")
    override fun onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)){
            this.drawerLayout.closeDrawer(GravityCompat.START)
        }else {
            super.onBackPressed()
        }

        supportActionBar!!.displayOptions = 12




    }


    //FUNCTIONS
    //=========================================================================================
    private fun closeNavigationDrawer(drawerLayout: DrawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            drawerLayout.openDrawer(GravityCompat.START)
        }

    }

    private fun goToFragment(fragment: Fragment){
        var backName = fragment.javaClass.name
        val manager = supportFragmentManager
        var fragmentsInBackStack = manager.popBackStackImmediate(backName,0)

        if (!fragmentsInBackStack){
            val fragmentTransaction = manager.beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .addToBackStack(backName)
            fragmentTransaction.commit()
        }

    }


    //=========================================================================================


}