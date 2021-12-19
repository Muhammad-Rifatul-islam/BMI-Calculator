package bd.edu.bd.bmicalculator;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bd.edu.bd.bmicalculator.databinding.FragmentHomeFragemntBinding;


public class HomeFragemnt extends Fragment {

    private FragmentHomeFragemntBinding binding;

    public HomeFragemnt() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeFragemntBinding.inflate(inflater);

        calculate();
        return binding.getRoot();
    }

    public void calculate() {


        binding.Calculate.setOnClickListener(v -> {
            final String weight= binding.weightEt.getText().toString();
            final String height = binding.heightEt.getText().toString();

            if (weight.isEmpty()){
                binding.weightEt.setError("Please Enter  Number");
                return;
            }
            if (height.isEmpty()){
                binding.heightEt.setError("Please Enter Number");
                return;
            }


            Bundle bundle=new Bundle();
            bundle.putString("weight",weight);
            bundle.putString("height",height);
            Navigation.findNavController(v).navigate(R.id.action_homeFragemnt_to_resultFragment,bundle);

        });



    }
}