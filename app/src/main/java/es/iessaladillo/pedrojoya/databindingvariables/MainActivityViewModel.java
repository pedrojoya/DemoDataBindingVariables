package es.iessaladillo.pedrojoya.databindingvariables;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

public class MainActivityViewModel extends ObservableViewModel {

    public MutableLiveData<String> name = new MutableLiveData<>();
    public LiveData<Boolean> validForm = Transformations.map(name, n -> !TextUtils.isEmpty(n));
    public ObservableField<String> buttonText = new ObservableField<>("Greet");
    public MutableLiveData<Integer> counter = new MutableLiveData<>();
    private boolean politely;

    public MainActivityViewModel() {
        counter.postValue(0);
    }

    @Bindable
    public boolean isPolitely() {
        return politely;
    }

    public void setPolitely(boolean politely) {
        this.politely = politely;
        notifyPropertyChanged(BR.politely);
    }

    public void incrementCounter() {
        counter.postValue(counter.getValue() + 1);
    }

    @Bindable({"politely"})
    public String getGreet() {
        return politely ? "Buenos días" : "Quillo que";
    }

    public void greet(View view) {
        Toast.makeText(view.getContext(), getGreet(), Toast.LENGTH_SHORT).show();
        incrementCounter();
    }

    public boolean btnOnLongClick(View v) {
        Toast.makeText(v.getContext(), "Han hecho long click", Toast.LENGTH_SHORT).show();
        return true;
    }

    public void nameAfterTextChanged(Editable s) {
        buttonText.set(String.valueOf(s.length()));
    }

}
