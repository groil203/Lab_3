package com.example.lab_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_3.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(MainActivity())
        val exercisesData = listOf(
            Pair("Присідання зі штангою", "https://comments.ua/img/publications/0PGSmteCmVN7Rqd4lXGZvu8HL8Hby4Pp.jpg"),
            Pair("Жим штанги лежачи","https://pic.sport.ua/images/media/orig/da/11608.jpg"),
            Pair("Станова тяга","https://cross.expert/wp-content/uploads/2017/01/stanovaya-tyaga.jpg"),
            Pair("Тяга штанги у нахилі", "https://stayfit.today/public/exercises/435/1L.jpg"),
            Pair("Армійський жим", "https://s3.amazonaws.com/prod.skimble/assets/1191529/image_iphone.jpg")
        )

        val exercisesInfoData = listOf(
            Pair("Для виконання присідань покладіть штангу на спину, зводячи лопатки. " +
                    "Далі опускайтеся строго до паралелі з підлогою, так як занадто низький присед шкодить колінам, а високий — неефективний." +
                    " Підборіддя тримайте піднесеним, зберігайте легкий прогин в спині. Вага тіла повинна бути перенесена на п’яти, при присіданні відводите таз назад. " +
                    "Піднімаючись з нижньої точки, розгинайте ноги не за рахунок колін, а за рахунок м’язів стегон і сідниць. ","https://znayu.org.ua/wp-content/uploads/2021/04/1618480998_Top-15-uprazhneniiy-dlya-nog-i-yagodic-so-shtangoiy-plany-zanyatiiy-dlya-muzhchin-i-zhenshin_2.gif"),
            Pair("Встановлюється лава з нахилом в 0 або 30 градусів. " +
                    "Встановлюється гриф на стійки або на обмежувачі силової рами з необхідною вагою. " +
                    "Атлет лягає на лаву так, щоб гриф розташовувався прямо над очима. " +
                    "Ноги широко розставляються і упираються всією ступнею в підлогу. " +
                    "Спина прогинається на природну величину або притискається до лави і фіксується. " +
                    "Гриф штанги потрібно брати самостійно або за допомогою партнера закритим хватом, ширина якого забезпечує перпендикулярність передпліч до підлоги в опущеному положенні або забезпечує розміщення зап'ястей над плечовими суглобами при зведених ліктях. "
                    ,"https://ferrum-body.ru/wp-content/uploads/2018/01/Wide-Grip-Barbell-Bench-Press-gif.gif"),
            Pair("Класична тяга виконується при вузько поставлених ногах. " +
                    "Гомілки ніг практично торкаються грифа штанги. " +
                    "Тут напруга переноситься на м'язи спини, біцепс стегна і сідничні м'язи. " +
                    "Квадріцепси включаються в роботу лише в початковій фазі підйому. " +
                    "При виконанні даної вправи важливо піднімати штангу рівномірно і вертикально, голову не опускати вниз, плечі повинні бути відведені назад, а лопатки зведені. " +
                    "Рекомендується атлетам зі слабкими ногами і короткими руками. " +
                    "У спортсменів з такими анатомічними особливостями сильно впливає на зміну техніки підйому штанги наявність коротких пальців."
                    ,"https://blog.pokupon.ua/wp-content/uploads/2021/05/stanovaia-tiaha.gif"),
            Pair("Підійдіть до штанги, постановка ніг - на ширині плечей і трохи зігнуті в колінах;" +
                    " Нахиліться і візьміться за гриф штанги прямим або зворотним хватом;" +
                    " Не згинаючи руки в ліктях, випрямтеся і підніміть штангу; " +
                    "Злегка прогните поперек і нахиліть корпус майже до паралелі з підлогою. " +
                    "Нахил потрібно робити більше, ніж на картинці вище. " +
                    "Гриф повинен бути в районі колін; Робимо вдих і плавно, без ривків, тягнемо штангу вгору. " +
                    "Лікті при цьому не відводимо в сторони, тягнемо штангу скорочуючи м'язи спини. " +
                    "У верхній точці тяги обов'язково максимально зводимо лопатки;"
                    ,"https://fitness.org.ua/wp-content/uploads/2019/04/b41200e50e4751cd010e48b61ea1cf16.gif"),
            Pair("Cтoячи нoги нa шиpині плeчeй. Bізьмітьcя зa штaнгy пpямим xвaтoм, pyки тaкoж нa шиpині плeчeй. " +
                    "3німіть штaнгy зі cтійки тaк, щoб гpyди тa плeчі oпинилиcя під гpифoм. " +
                    "Bідcтyпіть нaзaд нa зpyчнy відcтaнь, cпинy випpяміть, тpoxи зігніть кoлінa." +
                    "Bивіpeним pyxoм вичaвіть гpиф вгopy, pyки мaкcимaльнo poзпpяміть. " +
                    "Oбepeжнo oпycтіть cнapяд нa pівeнь гpyдeй. He викopиcтoвyйтe гpyди як підтpимкy. " +
                    "3poбіть пoтpібнy кількіcть пoвтopeнь. Підійдіть дo cтійки, пoвepніть штaнгy нa міcцe. Aбo oпycтіть нa підлoгy.","https://fitness.org.ua/wp-content/uploads/2022/05/armeyskiy-zhim-shtangi-stoya-vashsport.com.gif")


        )
        val bundle = Bundle()

        val adapter = ExercisesAdapter(exercisesData){ position ->
            bundle.putString("InfoName", exercisesData[position].first)
            bundle.putString("InfoText", exercisesInfoData[position].first)
            bundle.putString("InfoGif", exercisesInfoData[position].second)
            findNavController().navigate(R.id.action_listFragment_to_infoFragment, bundle)
        }

        binding.recyclerView.adapter = adapter
    }

}