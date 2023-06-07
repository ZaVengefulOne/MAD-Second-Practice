package com.example.mawfd.ui.fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.mawfd.R;
import com.example.mawfd.data.database.entity.Doctor;
import com.example.mawfd.databinding.FragmentDoctorlistBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.mawfd.ui.adapters.DoctorRecyclerAdapter;
import com.example.mawfd.ui.stateholder.viewModels.DoctorListViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class DoctorList extends Fragment {
    private DoctorListViewModel model;
    private FragmentDoctorlistBinding binding;
    public static String KEY_POS = "pos";
//    public DoctorList(){
//        super(R.layout.fragment_doctorlist);
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDoctorlistBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(this).get(DoctorListViewModel.class);
        model.listLiveData.observe(getViewLifecycleOwner(), new Observer<List<Doctor>>() {
//                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onChanged(List<Doctor> items) {
                    DoctorRecyclerAdapter adapter = new DoctorRecyclerAdapter(items);
//                    Log.d("Korpalo", "DOSTAL!");
                    adapter.onDoctorListItemListener = new DoctorRecyclerAdapter.OnDoctorListClickListener() {
                        @Override
                        public void onDoctorItemListClickListener(int position) {
                            Bundle bundle = new Bundle();
                            bundle.putInt(KEY_POS, position);
                            Navigation.findNavController(requireView())
                                    .navigate(R.id.action_list_to_profile, bundle);
                        }

                    };
                    binding.DoctorRecycler.setAdapter(adapter);
//                    adapter.notifyDataSetChanged();
//                    binding.DoctorRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                }
            });
        binding.BottomNavigation.setSelectedItemId(R.id.navigation_item1);
        binding.BottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_item0:
                        Navigation.findNavController(view).navigate(R.id.action_doctorlist_to_startfragment);
                        return true;
                    case R.id.navigation_item2:
                        Navigation.findNavController(view).navigate(R.id.action_list_to_appointments);
                        return true;
                    case R.id.navigation_item3:
                        Navigation.findNavController(view).navigate(R.id.action_list_to_library);
                        return true;
                    default:
                        return false;
                }
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

}
