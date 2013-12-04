package com.suyama.hiro.mall_k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.suyama.hiro.mall_k.R;
import com.suyama.hiro.mall_k.activities.ShopDetailActivity;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {
	private List<HashMap<String, String>> shops;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		shops = new ArrayList<HashMap<String,String>>();

		// Llenamos los datos de las tiendas (por ahora hardcoded)
		FillList();

		// Creamos el adapter para el ActivityView
		SimpleAdapter  adapter = new SimpleAdapter(
				this,
				shops,
				android.R.layout.simple_list_item_2, 
				new String[] {Shop.NAME, Shop.DESCRIPTION}, 
				new int[] {android.R.id.text1, android.R.id.text2});
	
		setListAdapter(adapter);
	}

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		TextView text1 = (TextView)v.findViewById(android.R.id.text1);
		
		// Buscamos la tienda en la lista para obtener sus datos y enviarlos a la otra actividad.
		for( HashMap<String, String> elemento: shops) {
			if( elemento.get(Shop.NAME).equals(text1.getText().toString()))
			{
				// Lanzamos la actividad con los detalles de la tienda.
				Intent intent = new Intent( getApplicationContext(), ShopDetailActivity.class );	
				intent.putExtra("map", elemento);
				startActivity(intent);
				break;
			}
		}
		
		super.onListItemClick(l, v, position, id);
	}


	private void FillList() {
		
		HashMap<String, String> element;
		
		// Cargamos los elementos de la lista hardcoded
		element = new HashMap<String, String>();
		element.put(Shop.NAME, 			"La Herradura");
		element.put(Shop.DESCRIPTION, 	"Minimercado");
		element.put(Shop.ADDRESS, 		"Diagonal Brown 11");
		element.put(Shop.PHONE, 		"1142931122");
		element.put(Shop.WEBSITE,		"www.laherradura.com.ar");
		element.put(Shop.EMAIL,			"info@laherradura.com.ar");
		element.put(Shop.SCHEDULE, 		"8:00 a 12:00\n13:00 a 21:00");
		element.put(Shop.IMAGE,			String.valueOf(R.drawable.laherradura));
		element.put(Shop.IMAGECOMMENT,	"Imagen de la Tienda");
		
		shops.add(element);

	
		element = new HashMap<String, String>();
		element.put(Shop.NAME, 			"Summus");
		element.put(Shop.DESCRIPTION, 	"Panaderia");
		element.put(Shop.ADDRESS, 		"Esteban Adrogue 123");
		element.put(Shop.PHONE, 		"1142945678");
		element.put(Shop.WEBSITE,		"www.summus.com.ar");
		element.put(Shop.EMAIL,			"info@summus.com.ar");
		element.put(Shop.SCHEDULE, 		"8:00 a 12:00\n13:00 a 21:00");
		element.put(Shop.IMAGE,			String.valueOf(R.drawable.summus));
		element.put(Shop.IMAGECOMMENT,	"Imagen de la Tienda");
		
		shops.add(element);
		
		element = new HashMap<String, String>();
		element.put(Shop.NAME, 			"La Fabrica");
		element.put(Shop.DESCRIPTION, 	"Sandwiches");
		element.put(Shop.ADDRESS, 		"Diagonal Brown 321");
		element.put(Shop.PHONE, 		"01142933344");
		element.put(Shop.WEBSITE,		"www.lafabrica.com.ar");
		element.put(Shop.EMAIL,			"info@lafabrica.com.ar");
		element.put(Shop.SCHEDULE, 		"8:00 a 12:00\n13:00 a 21:00");
		element.put(Shop.IMAGE,			String.valueOf(R.drawable.lafabrica));
		element.put(Shop.IMAGECOMMENT,	"Imagen de la Tienda");
		
		shops.add(element);

		element = new HashMap<String, String>();
		element.put(Shop.NAME, 			"Libreria del Colegio");
		element.put(Shop.DESCRIPTION, 	"Libreria");
		element.put(Shop.ADDRESS, 		"Diagonal Brown 23");
		element.put(Shop.WEBSITE,		"www.libreriadelcolegio.com.ar");
		element.put(Shop.EMAIL,			"info@libreriadelcolegio.com.ar");
		element.put(Shop.SCHEDULE, 		"8:00 a 12:00\n13:00 a 21:00");
		element.put(Shop.PHONE, 		"01142939876");
		element.put(Shop.IMAGE,			String.valueOf(R.drawable.libreriadelcolegio));
		element.put(Shop.IMAGECOMMENT,	"Imagen de la Tienda");
		
		shops.add(element);
		
		element = new HashMap<String, String>();
		element.put(Shop.NAME, 			"Los Amores");
		element.put(Shop.DESCRIPTION, 	"Heladeria");
		element.put(Shop.ADDRESS, 		"Rosales 123");
		element.put(Shop.WEBSITE,		"www.losamores.com.ar");
		element.put(Shop.EMAIL,			"info@losamores.com.ar");
		element.put(Shop.SCHEDULE, 		"8:00 a 12:00\n13:00 a 21:00");
		element.put(Shop.PHONE, 		"01142934455");
		element.put(Shop.IMAGE,			String.valueOf(R.drawable.losamores));
		element.put(Shop.IMAGECOMMENT,	"Imagen de la Tienda");
		
		shops.add(element);

		element = new HashMap<String, String>();
		element.put(Shop.NAME, 			"Hispamar");
		element.put(Shop.DESCRIPTION, 	"Pescaedria");
		element.put(Shop.ADDRESS, 		"Bynon 1212");
		element.put(Shop.WEBSITE,		"www.hispamar.com.ar");
		element.put(Shop.EMAIL,			"info@hispamar.com.ar");
		element.put(Shop.SCHEDULE, 		"8:00 a 12:00\n13:00 a 21:00");
		element.put(Shop.PHONE, 		"01142936655");
		element.put(Shop.IMAGE,			String.valueOf(R.drawable.hispamar));
		element.put(Shop.IMAGECOMMENT,	"Imagen de la Tienda");
		
		shops.add(element);
	}

}
