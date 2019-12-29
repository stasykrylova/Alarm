package com.example.alarm;


/*
public class AlarmFragment extends Fragment implements AlarmContract.View {
    private  AlarmContract.Presenter presenter;
    public   AlarmFragment(){

    }
    public static com.example.alarm.alarm.AlarmFragment newInstance(){//instance - экземпляр конкр значение
        return new com.example.alarm.alarm.AlarmFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // оч важна!!
        setRetainInstance(true);//сохранение состояния при повороте (не пересоздание)
    } // супер используется ждя вызова конструктора суперкласа или для обращения к скрытому члену
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v=inflater.inflate(R.layout.fragment_reminder_list, container,false);
        return v;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        if(presenter==null) {
            presenter = new AlarmPresenter(this)

        }
        presenter.subscribe();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

    }
    @Override
    public void onDetach(){
        super.onDetach();
    }
    @Override
    public void onDestroy(){
        presenter.unsubscribe();
        super.onDestroy();
    }

    @Override
    public void setPresenter(AlarmContract.Presenter presenter) {

    }

    @Override
    public void makeToast(String message) {

    }
}
54
*/
