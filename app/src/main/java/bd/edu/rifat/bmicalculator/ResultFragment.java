package bd.edu.rifat.bmicalculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bd.edu.rifat.bmicalculator.databinding.FragmentResultBinding;


public class ResultFragment extends Fragment {

    private FragmentResultBinding binding;

    public ResultFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding=FragmentResultBinding.inflate(inflater);

        getCalculate();
        showReference();
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private void showReference() {

        binding.referenceBtn.setOnClickListener(v -> {

            Navigation.findNavController(v).navigate(R.id.action_resultFragment_to_referenceFragement);

        });
    }


    private void getCalculate() {



        Bundle bundle=getArguments();

        double weight=Double.parseDouble(bundle.getString("weight"));

        double height=Double.parseDouble(bundle.getString("height"));

        double bmi=weight/(height*height);



        if (bmi<18.5){
            binding.score.setText(String.format("%.2f ",bmi));
            binding.bmiName.setText("You Are underWeight");
        }
        else if (bmi>=18.5 && bmi<=24.9){
            binding.score.setText(String.format("%.2f ",bmi));
            binding.bmiName.setText("You Are Normal");

        }
        else if (bmi>=25.0&& bmi<=29.9){
            binding.score.setText(String.format("%.2f ",bmi));
            binding.bmiName.setText("You Are OverWeight");
        }
        else if(bmi>=30)
        {
            binding.score.setText(String.format("%.2f ",bmi));
            binding.bmiName.setText("You Are very OverWeight");
        }

    }




}