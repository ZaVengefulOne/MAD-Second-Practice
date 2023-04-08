package com.example.mawfd.ui.fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mawfd.R;
import com.example.mawfd.data.models.DoctorListItem;
import com.example.mawfd.databinding.FragmentDoctorlistBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.mawfd.data.models.ScheduleRecyclerItem;
import com.example.mawfd.ui.stateholder.DoctorRecyclerAdapter;
import com.example.mawfd.ui.stateholder.viewModels.DoctorListItemViewModel;
import com.example.mawfd.ui.stateholder.viewModels.DoctorListViewModel;

import java.util.List;

public class DoctorList extends Fragment {
    private DoctorListViewModel model;
    private FragmentDoctorlistBinding binding;
    private DoctorListItemViewModel viewModel;
    public static String KEY_POS = "pos";
    public DoctorList(){
        super(R.layout.fragment_doctorlist);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDoctorlistBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        model = new ViewModelProvider(this).get(DoctorListViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        model.listLiveData.observe(getViewLifecycleOwner(), new Observer<List<DoctorListItem>>() {
                @Override
                public void onChanged(List<DoctorListItem> items) {
                    DoctorRecyclerAdapter adapter = new DoctorRecyclerAdapter(items);
                    binding.DoctorRecycler.setAdapter(adapter);
                    adapter.onDoctorListItemListener = new DoctorRecyclerAdapter.OnDoctorListClickListener() {
                        @Override
                        public void onDoctorItemListClickListener(int position) {
                            Bundle bundle = new Bundle();
                            bundle.putInt(KEY_POS, position);
                            Navigation.findNavController(requireView()).navigate(R.id.action_list_to_profile, bundle);
                        }

                    };

                }
            });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_doctorlist_to_startfragment);
            }
        });

    }

}