package com.example.mawfd.ui.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.mawfd.R;
import com.example.mawfd.data.models.LoginUser;
import com.example.mawfd.databinding.FragmentEntranceBinding;
import com.example.mawfd.ui.stateholder.viewModels.EntranceViewModel;

public class EntranceFragment extends Fragment {
    private FragmentEntranceBinding binding;
    private static final String SHARED_PREF_NAME = "name";
    public static final String KEYL = "login";
    public static final String KEYP = "password";
    private EntranceViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentEntranceBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(EntranceViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        pars();
        // чтение
        SharedPreferences sharedPrefRead =
                requireActivity().getPreferences(Context.MODE_PRIVATE);
        String loginSP = sharedPrefRead.getString(SHARED_PREF_NAME, "");
        binding.LoginText.setText(loginSP);

        binding.enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // запись
                SharedPreferences sharedPrefWrite =
                        requireActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefWrite.edit();
                editor.putString(SHARED_PREF_NAME,
                        binding.LoginText.getText().toString());
                editor.apply();

                if(viewModel.loginAccount(
                        binding.LoginText.getText().toString(),
                        binding.PasswordText.getText().toString()
                ))
                    Navigation.findNavController(view).navigate(R.id.action_entrance_to_startfragment);

            }
        });
        binding.admbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_entrance_to_adminentrance);
            }
        });
    }
    private void pars(){
        Bundle bundle = this.getArguments();
        if (bundle != null){
            if (bundle.getString(KEYL) == null) {
                String Login = bundle.getString(KEYL);
                String Password = bundle.getString(KEYP);
                binding.LoginText.setText(Login);
                binding.PasswordText.setText(Password);
            }
            else{
                String Login = bundle.getString(KEYL);
                binding.LoginText.setText(Login);
            }
        }
    }
    public static EntranceFragment newInstance(String Phone, String Password) {
        EntranceFragment entranceFragment = new EntranceFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEYL, Phone);
        bundle.putString(KEYP, Password);
        entranceFragment.setArguments(bundle);
        return entranceFragment;
    }
}
