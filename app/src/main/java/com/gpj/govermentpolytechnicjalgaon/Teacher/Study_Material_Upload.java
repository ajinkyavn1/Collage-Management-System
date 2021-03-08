package com.gpj.govermentpolytechnicjalgaon.Teacher;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.gpj.govermentpolytechnicjalgaon.R;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import java.util.UUID;

import static android.app.Activity.RESULT_OK;

public class Study_Material_Upload extends Fragment implements View.OnClickListener {
View rootView;
    private Button buttonChoose;
    private Button buttonUpload;

    private EditText editText;

    public static final String UPLOAD_URL = "http://192.168.43.196/gpj/Departments/IT/Teacher/Syllabus/upload.php";

    ImageView imageView;

    private int PICK_PDF_REQUEST = 1;

    //storage permission code
    private static final int STORAGE_PERMISSION_CODE = 123;

    //Bitmap to get image from gallery
    private Bitmap bitmap;

    //Uri to store the image uri
    private Uri filePath;

    //ListView to show the fetched Pdfs from the server
    ListView listView;

    //button to fetch the intiate the fetching of pdfs.
    Button buttonFetch;

    //Progress bar to check the progress of obtaining pdfs
    ProgressDialog progressDialog;

    //an array to hold the different pdf objects
  //  ArrayList<Pdf> pdfList = new ArrayList<Pdf>();

    //pdf adapter

    //PdfAdapter pdfAdapter;

    public Study_Material_Upload() {
        // Required empty public constructor
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       rootView=inflater.inflate(R.layout.study__material_upload, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        //Requesting storage permission
        requestStoragePermission();

        //Initializing views
        buttonChoose = (Button) rootView.findViewById(R.id.buttonChoose);
        buttonUpload = (Button)rootView.findViewById(R.id.buttonUpload);


        editText = (EditText) rootView.findViewById(R.id.editTextName);

        //initializing ListView

        //initializing progressDialog

       progressDialog = new ProgressDialog(getContext());

        //Setting clicklistener
        buttonChoose.setOnClickListener(this);
        buttonUpload.setOnClickListener(this);
        return rootView;
    }


    public void uploadMultipart() {
        //getting name for the pdf
        String name = editText.getText().toString().trim();

        //getting the actual path of the pdf
        String path = FilePath.getPath(getActivity(), filePath);

        if (path == null) {

            Toast.makeText(getActivity(), "Please Select file to internal storage and retry", Toast.LENGTH_LONG).show();
        } else {
            //Uploading code
            try {
                String uploadId = UUID.randomUUID().toString();

                //Creating a multi part request
                new MultipartUploadRequest(getActivity(), uploadId, UPLOAD_URL)
                        .addFileToUpload(path, "pdf") //Adding file
                        .addParameter("name", name) //Adding text parameter to the request
                        .setMaxRetries(2)
                        .startUpload(); //Starting the upload

            } catch (Exception exc) {
                Toast.makeText(getActivity(), exc.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }


    //method to show file chooser
    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Pdf"), PICK_PDF_REQUEST);
    }

    //handling the ima chooser activity result
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_PDF_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();

        }
    }


    //Requesting permission
    private void requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return;

        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }
        //And finally ask for the permission
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.INSTANT_APP_FOREGROUND_SERVICE}, STORAGE_PERMISSION_CODE);

    }


    //This method will be called when the user will tap on allow or deny
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //Checking the request code of our request
        if (requestCode == STORAGE_PERMISSION_CODE) {

            //If permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Displaying a toast
                Toast.makeText(getActivity(), "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(getActivity(), "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    public void onClick(View v) {
        if (v == buttonChoose) {
            showFileChooser();
        }
        if (v == buttonUpload) {
            uploadMultipart();
        }

    }



}
