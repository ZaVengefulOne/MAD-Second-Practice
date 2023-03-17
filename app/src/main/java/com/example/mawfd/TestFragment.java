package com.example.mawfd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mawfd.databinding.FragmentTestBinding;
import java.util.ArrayList;
import java.util.List;


public class TestFragment extends Fragment {
    private FragmentTestBinding binding;
    private static final String TAG = "mafwd";
    public static final String KEY = "key";
    public TestFragment(){
        super(R.layout.fragment_test);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTestBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    private void pars(){
        Bundle bundle = this.getArguments();
        Toast.makeText(getContext(), "Bundle recieved!", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pars();
        List<ScheduleRecyclerItem> listItems = new ArrayList<>();
        String[] doctorProfiles = new String[]{"Терапевт", "Отоларинголог", "Педиатр"};
        for (int i = 0; i < 200; i++) {
            listItems.add(new ScheduleRecyclerItem(R.drawable.medical_59_icon_icons_com_73933, doctorProfiles[(int) (Math.random() * doctorProfiles.length)]));
        }
        ScheduleRecyclerAdapter adapter = new ScheduleRecyclerAdapter(getContext(), listItems);
        binding.RecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                requireActivity().getSupportFragmentManager().beginTransaction()
//                        .addToBackStack(null)
//                        .replace(R.id.fragment_container, new StartFrameFragment())
//                        .commit();
                Navigation.findNavController(view).navigate(R.id.action_test_to_startfragment);
            }
        });
    }
    }



