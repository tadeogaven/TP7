package com.example.tp7am;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import org.cocos2d.layers.Layer;
import org.cocos2d.nodes.Director;
import org.cocos2d.nodes.Scene;
import org.cocos2d.nodes.Sprite;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.types.CCSize;

public class MainActivity extends Activity {
    CCGLSurfaceView VistaPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        VistaPrincipal = new CCGLSurfaceView (this);
        setContentView(VistaPrincipal);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        clsJuego juego;
        juego = new clsJuego(VistaPrincipal);
        juego.ComenzarJuego();
    }

    public class clsJuego
    {
        CCGLSurfaceView _VistaDelJuego;
        CCSize _Pantalla;
        Sprite _Jugador;

        public clsJuego(CCGLSurfaceView VistaDelJuego)
        {
            Log.d("clsJuego", "comienza el constructor de la clase");
            _VistaDelJuego = VistaDelJuego;
        }

        public void ComenzarJuego()
        {
            Log.d("ComenzarJuego", "Comienza el juego");
            Director.sharedDirector().attachInView(_VistaDelJuego);

            Log.d("ComenzarJuego","Declaro e instancio la escena");
            Scene escenaAUsar;
            escenaAUsar = EscenaComienzo();

            _Pantalla= Director.sharedDirector().displaySize();
            Log.d("ComenzarJuego","Pantalla - Ancho"+ _Pantalla.getWidth()+ "-Alto"+_Pantalla.getHeight());

            Log.d("ComenzarJuego","Le digo al director que inicie la escena");
            Director.sharedDirector().runWithScene(escenaAUsar);
        }

        private Scene EscenaComienzo()
        {
            Log.d("Escena del comienzo","Comienza");
            Scene escenaADevolver;
            escenaADevolver = Scene.node();

            Log.d("Escena del comienzo","Voy a agregar la capa");
            capaJuego unaCapa;
            unaCapa = new capaJuego();
            escenaADevolver.addChild(unaCapa);

            Log.d("Escena del comienzo", "Devuelvo la escena creada");
            return escenaADevolver;
        }

        class capaJuego extends Layer
        {

        }
    }

}
