package com.example.dell_pc.server_demo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    Button button,button2,buttonz_func3,buttonz_func4,buttonz_func5,buttonz_func6;
    String url="http://192.168.0.100/MegaBio1/MegaMindService.svc/OnlyStringInfo1";
    String url_1="http://192.168.0.100/MegaBio1/MegaMindService.svc/OnlyStringInfo2";
    private static final String REGISTER_URL = "http://192.168.0.100/MegaBio1/MegaMindService.svc/OnlyStringInfo";
    String url_2="http://192.168.0.100/MegaBio1/MegaMindService.svc/OnlyStringInfo3";
    String url_3="http://192.168.0.100/MegaBio1/MegaMindService.svc/PostImage";
    String url_4="http://192.168.0.100/MegaBio1/MegaMindService.svc/insPunchInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2=(Button)findViewById(R.id.buttonRegister);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                            }
                        });

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
            }
        });
        final HashMap<String, String> params = new HashMap<>();
        params.put("name", "vikash");
        params.put("lname", "1111");

        button=(Button)findViewById(R.id.server);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,url, new JSONObject(params),
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();

                    }
                });
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(req);

            }
        });

       final HashMap<String, String> params_1 = new HashMap<>();
        params_1.put("name", "vikash");
        params_1.put("lname", "1111");

        buttonz_func3=(Button)findViewById(R.id.button3);
        buttonz_func3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,url_1, new JSONObject(params_1),
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();

                    }
                });
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(req);

            }
        });

        try {
            final JSONObject myObject = new JSONObject();
            JSONObject values = new JSONObject();
            values.put("userid", "Jack");
            values.put("username", "Jhonson");
            myObject.put("um",values);


        buttonz_func4=(Button)findViewById(R.id.button4);
        buttonz_func4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),myObject.toString(),Toast.LENGTH_LONG).show();
                JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,url_2, myObject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();

                    }
                });
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(req);

            }
        });
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //not working
        try {
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.mega2);
        final JSONObject values = new JSONObject();
                values.put("sm", bitmap);
            buttonz_func5=(Button)findViewById(R.id.button5);
            buttonz_func5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,url_3, values,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();

                    }
                });
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(req);

            }
        });
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
        final JSONObject pm = new JSONObject();
        JSONObject params_final = new JSONObject();
        params_final.put("userid", "vikash");
        params_final.put("PunchDateTime", "20170419154403");
        params_final.put("DeviceID_HR", "vikash");
        params_final.put("DeviceID_Unique", "1111");
        params_final.put("PunchMode", "v");
        params_final.put("Latitude", "1111");
        params_final.put("Longitude", "vikash");
        params_final.put("MatchScore", "1111");
        params_final.put("FingerQuality", "vikash");
        params_final.put("PhotoFileName", "1111");
        params_final.put("Field1", "vikash");
        params_final.put("Field2", "1111");
        params_final.put("Field3", "vikash");
        params_final.put("Field4", "1111");
        params_final.put("Field5", "vikash");
        pm.put("punchinfo",params_final);

        buttonz_func6=(Button)findViewById(R.id.button6);
        buttonz_func6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,url_4, pm,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();

                    }
                });
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(req);

            }
        });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
