package com.example.animcare

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.animcare.Classes.*
import com.example.animcare.DatabaseFiles.DataBase
import com.example.animcare.Dogs.CavalierKingCharlesSpaniel
import com.example.animcare.MainActivityFiles.Fragments.*
import com.example.animcare.MainActivityFiles.MyPets.Fragments.PetsFragment
import com.example.animcare.Options.OptionsFragment
import com.example.animcare.Quizzes.Cats
import com.example.animcare.Quizzes.Dogs
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.nav_header.*

class MainActivity : AppCompatActivity() {

    val didacticsFragment = DidacticsFragment()
    val quizFragment = QuizFragment()
    val optionFragment = OptionFragment()
    val accountFragment = AccountFragment()
    val diseaseDetectionFragment = DiseaseDetectionFragment()
    @RequiresApi(Build.VERSION_CODES.O)
    val petsFragment = PetsFragment()
    val optionsFragment = OptionsFragment()
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
        "Weso??y, ??ywy, energiczny i skory do zabawy; nieufny wobec obcych, oddany w??a??cicielowi",
        "5-10kg",
        "??niade, ??niade z bia??ym, marmurkowe, czarne podpalane z bia??ymi znaczeniami, czarne podpalane",
        "psy - 34,5-39,5 cm, suki - 33,5-38,5 cm",
        "Szkocja",
        "12 do 13 lat",
        CustomText(
            "OwczarekSzetlandzki",
            arrayListOf(
                Section("0", "Piel??gnacja",
                    arrayListOf(
                        Paragraph("0", "image",
                                ImageLocalization("https://firebasestorage.googleapis.com/v0/b/animcare-ea72d.appspot.com/o/pielegnacja1.png?alt=media&token=88394751-d88d-4d6f-9617-6aaccee6fd92"),
                            "null"
                            ),
                        Paragraph("1", "text",
                            ImageLocalization(),
                            "D??uga sier???? i g??sty podszerstek sprawiaj??, ??e owczarek szetlandzki jest ras??, " +
                                    "kt??ra potrzebuje dosy?? intensywnej piel??gnacji. " +
                                    "Wprawdzie nie jest to proceder tak wymagaj??cy, jak w przypadku du??ych ras, " +
                                    "ale mimo wszystko wymaga regularnego szczotkowania. Sheltie linieje dwa razy w roku, " +
                                    "jednak niekt??re osobniki mog?? gubi?? sier???? nawet przez ca??y rok. " +
                                    "Regularne czesanie jest wa??ne, poniewa?? pozwala na usuwanie martwego w??osia na bie????co."
                        ),
                        Paragraph("2", "text",
                        ImageLocalization(),
                            "Po intensywnym spacerze, podczas kt??rego pies ma szans?? ubrudzi?? si?? b??otem, " +
                                    "warto go wyk??pa?? a nast??pnie dok??adnie wysuszy??."
                        ),
                        Paragraph("3", "text",
                            ImageLocalization(),
                            "W przypadku rasy owczarek szetlandzki ??ywienie nie musi odbiega?? od " +
                                    "jad??ospisu innych ma??ych ps??w. Sheltie maj?? pewn?? sk??onno???? do tycia, " +
                                    "dlatego warto zapewni?? im wysokiej jako??ci karm?? bogat?? w bia??ko i ubog?? w " +
                                    "w??glowodany. Dobrym rozwi??zaniem b??dzie tak??e dieta BARF oparta na " +
                                    "surowym mi??sie i indywidualnie dobranych suplementach. " +
                                    "Kluczem do zachowania dobrej sylwetki jest aktywno???? fizyczna i unikanie " +
                                    "dokarmiania psa pomi??dzy posi??kami. ??ywienie owczarka szetlandzkiego " +
                                    "powinno by?? dobrze zaplanowane i zr??wnowa??one."
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
                            "Owczarek szetlandzki jest coraz bardziej popularn?? ras?? w naszym kraju, " +
                                    "dlatego z ka??dym rokiem pojawia si?? coraz wi??cej nowych hodowli. " +
                                    "Niestety, tak jak w przypadku wszystkich ras, kt??re zyskuj?? na popularno??ci, " +
                                    "jest to prawdziwa po??ywka dla pseudohodowc??w. W??a??nie dlatego, " +
                                    "zanim jeszcze zaczniesz szuka?? szczeniaka, zapami??taj, " +
                                    "aby wybiera?? tylko te hodowle, kt??re s?? zarejestrowane " +
                                    "w Zwi??zku Kynologicznym w Polsce."
                            )

                    )
                    ),
                Section("2", "Cena",
                    arrayListOf(
                        Paragraph("0", "text", ImageLocalization(),
                        "Znalezienie hodowli ps??w tej rasy nie jest obecnie szczeg??lnie trudne. " +
                                "Cena owczarka szetlandzkiego wynosi od dw??ch do czterech tysi??cy z??otych. " +
                                "Warto jednak zaznaczy??, ??e jest ona zawsze ustalana indywidualnie przez hodowc??. "
                        ),
                        Paragraph("1", "text", ImageLocalization(),
                        "Szczeg??lnie popularne w ostatnim czasie jest umaszczenie blue merle. " +
                                "Takie pieski s?? te?? najdro??sze. Poszukuj??c szczeniaka, " +
                                "kieruj si?? jednak jego charakterem, a nie wygl??dem. " +
                                "O tym, jaki szczeniak najbardziej pasuje do twojej rodziny, " +
                                "dowiesz si?? od hodowcy. "
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

//
//        auth = Firebase.auth
//        auth.signInWithEmailAndPassword("kamilwin21@gmail.com", "123456789")
//            .addOnCompleteListener(this){
//                if(it.isSuccessful){
//                    Toast.makeText(applicationContext, "Successed Login", Toast.LENGTH_SHORT).show()
//                }else{
//                    Toast.makeText(applicationContext, "Failed Login", Toast.LENGTH_SHORT).show()
//                }
//            }


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
                R.id.userOption -> {
                    goToFragment(optionsFragment)
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
        var sa = R.drawable.default_profile_image
        var str = sa.toString()



        println("STR: ${str}")
//        imageViewNavHeader.background = ContextCompat.getDrawable(applicationContext, "${R.drawable.default_profile_image}".toInt())
//        imageViewNavHeader.background = ContextCompat.getDrawable(applicationContext, str.toInt())

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
        nameNavHeader.text = getNameFromEmail(FirebaseAuth.getInstance().currentUser?.email.toString())
        var connect = FirebaseDatabase.getInstance(DataBase.dbReferName).reference
//        println("UID: ${FirebaseAuth.getInstance().currentUser!!.uid}")
        if(FirebaseAuth.getInstance().currentUser?.uid != null){
            connect.child("Users").child(FirebaseAuth.getInstance().currentUser!!.uid)
                .child("imagePath")
                .addValueEventListener(object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()){
//                        imageViewNavHeader.background = ContextCompat.getDrawable(applicationContext, snapshot.value.toString().toInt())
                            var uri = Uri.parse(snapshot.getValue(String::class.java))
                            var inputSteam = applicationContext.contentResolver.openInputStream(uri)
                            println("URI: ${snapshot}")
                            imageViewNavHeader.background = Drawable.createFromStream(inputSteam, snapshot.getValue(String::class.java))

                        }
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })

        }



//        imageViewNavHeader.background = ContextCompat.getDrawable(applicationContext, R.drawable.default_profile_image)
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

    private fun getNameFromEmail(userEmail: String): String {
        var email = userEmail


        return email.substringBefore("@")
    }
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