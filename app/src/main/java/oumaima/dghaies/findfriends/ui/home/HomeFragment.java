package oumaima.dghaies.findfriends.ui.home;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import oumaima.dghaies.findfriends.MainActivity;
import oumaima.dghaies.findfriends.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.btnEnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  numero=binding.edNum.getText().toString();
                //Envoyer un sms
                //getDefaultSmsSubscriptionId lire les numeros des sms
                if(MainActivity.permission){
                    SmsManager manager=SmsManager.getDefault();//sim par defaut
                    manager.sendTextMessage(numero,
                            null,
                            "Findme: Envoyer moi votre position",
                            null,null);

                 }
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}