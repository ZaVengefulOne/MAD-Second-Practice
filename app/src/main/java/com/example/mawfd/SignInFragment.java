package com.example.mawfd;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


import com.example.mawfd.databinding.FragmentSigninBinding;

import java.util.ArrayList;
import java.util.List;

public class SignInFragment extends Fragment {
    private static final String TAG = "mafwd";
    public static final String KEY = "key";
    public SignInFragment(){
        super(R.layout.fragment_signin);
    }
    private FragmentSigninBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSigninBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<ScheduleListItem> listItems = new ArrayList<>();
        String[] doctorProfiles = new String[]{"Терапевт", "Отоларинголог", "Педиатр"};
        for (int i = 0; i < 200; i++){
            listItems.add(new ScheduleListItem(R.drawable.medical_59_icon_icons_com_73933, doctorProfiles[(int) (Math.random() * doctorProfiles.length)]));
        }
        ScheduleListAdapter adapter = new ScheduleListAdapter(getContext(), R.layout.item_schedule_list, listItems);
        binding.ProfilesList.setAdapter(adapter);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                requireActivity().getSupportFragmentManager().beginTransaction()
//                        .addToBackStack(null)
//                        .replace(R.id.fragment_container, new StartFrameFragment())
//                        .commit();
                Navigation.findNavController(view).navigate(R.id.action_signin_to_startfragment);
            }
        });
    }

    public void getArgs() {
        Bundle bundle = this.getArguments();
        if (bundle != null){
            String result = bundle.getString(KEY);
        }
    }
    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
        String result = bundle.getString("bundleKey");
    }
}
