package es.iessaladillo.pedrojoya.databindingvariables;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import es.iessaladillo.pedrojoya.databindingvariables.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainActivityViewModel vm = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        b.setLifecycleOwner(this);
        b.setVm(vm);
    }
}
