import { Component, OnInit, EventEmitter, Output, HostListener } from '@angular/core';
import * as $ from 'jquery';
import { FormGroup, FormControl } from '@angular/forms';
import { timeTouchEvent } from 'src/app/globals';

@Component({
  selector: 'app-representacion',
  templateUrl: './representacion.component.html',
  styleUrls: ['./representacion.component.scss']
})
export class RepresentacionComponent implements OnInit {

  representacion:any=[];

  form:FormGroup;
  declaracionInicio:boolean=false;
  help = false;
  noEmpleo: any;

  @Output() modificar = new EventEmitter();
  @Output() eliminar = new EventEmitter();
  @Output() acla = new EventEmitter();
  @Output() ninguno = new EventEmitter();
  aclara: string;
  r: any;

  endTimeTouch
  startTimeTouch

  /* Contar touchEnd events */
  countTouches = 0
  countFingers

  /* Datos de la distacia del touch Event */
  distanceTouch
  startScreenTouch
  endScreenTouch
  aclaObs: any;

  /* Escuchar cuando el touch se mueva */
  @HostListener('touchmove', ['$event'])
  moveTouch(event) {
    // Obtener el No. dedos del evento touch
    this.countFingers = event.touches.length
    // Calcular distancia recorrida desde el punto inicial
    this.distanceTouch = event.changedTouches[0].clientX - this.startScreenTouch
  }

  /* Escuchar cuando inicie el evento touch */
  @HostListener('touchstart', ['$event'])
  start(event) {
    // Settear el momento en que inicia el evento touch
    this.startTimeTouch = new Date().getTime()
    // Settear posición en que inicia el evento touch
    this.startScreenTouch = event.changedTouches[0].clientX
  }

  div=document.getElementById('scrollRe');
  @HostListener('touchend', ['$event'])
  stop(event) {
    this.div = document.getElementById('scrollRe');
    // Setter el momento en que termina el touch event
    this.endTimeTouch = new Date().getTime()
    // Calcular diferencia de tiempo de inicio al fin del evento touch
    let diff = this.endTimeTouch - this.startTimeTouch
    // Valida si el elemento tiene scrollBars
    if (this.div['scrollHeight'] != this.div['clientHeight']) {
      // Valida que el movimiento sea con dos dedos
      if (this.countFingers === 2) {

        this.countTouches++
        // Cuando sea 2 es porque quitó los dos dedos de la pantalla
        if (this.countTouches === 2) {
          // Valida que exista el momento de inicio del evento
          if (this.startTimeTouch)
            // Valida la velocidad del movimiento
            if (diff < timeTouchEvent) {
              // Si la distancia es > 0 avanza a la siguiente sección
              if (this.distanceTouch > 0) document.getElementById('goForwardBtn').click()
              // Si la distancia es < 0 regresa a la sección anterior
              if (this.distanceTouch < 0) document.getElementById('goBackBtn').click()
            }
          this.countTouches = 0 // Settear a 0 el némero de de touchEnd events
        }
      }
    } else
      // Valida la velocidad del movimiento
      if (diff < timeTouchEvent) {
        // Si la distancia es > 0 avanza a la siguiente sección
        if (this.distanceTouch > 0) document.getElementById('goForwardBtn').click()
        // Si la distancia es < 0 regresa a la sección anterior
        if (this.distanceTouch < 0) document.getElementById('goBackBtn').click()
      }
  }

  @HostListener('mousewheel', ['$event'])
  _wheel(event: MouseEvent) {
    this.div = document.getElementById('scrollRe');
    // Obtener elemento que tiene el scroll
    // Si tiene scroll detiene la propagación del componente padre
    if (this.div['scrollHeight'] != this.div['clientHeight']) event.stopPropagation()
    if (this.div['offsetHeight'] != this.div['scrollHeight'])
      // Valida que este en el top del elemto y la dirección del scroll sea hacia arriba
      if (this.div['scrollTop'] + this.div['offsetHeight'] + 1 > this.div['scrollHeight'] && event['wheelDeltaY'] < 0)
        document.getElementById('goForwardBtn').click()
      // Valida que este en el bottom del elemto y la dirección del scroll sea hacia abajo
      else if (this.div['scrollTop'] === 0 && event['wheelDeltaY'] > 0)
        document.getElementById('goBackBtn').click()
  }

  constructor() { }

  ngOnInit() {
    let ac = JSON.parse(sessionStorage.getItem('representaciones'));
    this.aclara=ac.aclaracionesObservaciones;
    
    this.getDatos();


    this.form = new FormGroup({
      'tipoPersona': new FormControl(' '),
      'tipoRepresentacion': new FormControl(' '),
      'representante': new FormControl(' '),
      'recibeRemuneracion': new FormControl(' '),
      'sectorProductivo': new FormControl(' '),
      'lugarUbica': new FormControl(' ')

    });
  }

  getDatos() {
    this.r = JSON.parse(sessionStorage.getItem('representaciones'));
    this.aclara = this.r.aclaracionesObservaciones;
    this.representacion = this.r.representaciones || [];
    console.log("represen data ",this.representacion);

  }


  abrirObservaciones() {
    $('body').addClass('disabled-onepage-scroll');
    $("#obs-representacion").css({ "display": "flex" });
    $(".menu-nav").css({ "display": "none" });
    $("#content-btnSave").css({ "display": "none" });
    this.aclaObs=this.aclara;
  }

  cerrarObservaciones() {
    $('body').removeClass('disabled-onepage-scroll');
    $("#obs-representacion").css("display", "none");
    $(".menu-nav").css({ "display": "flex" });
    $("#content-btnSave").css({ "display": "flex" });
    this.aclaObs=this.aclara;
  }

  guardarObservaciones(){
    let dataAclara = this.aclaObs;  
    let repre= JSON.parse(sessionStorage.getItem('representaciones'));  
    repre.aclaracionesObservaciones=dataAclara;
    sessionStorage.setItem('representaciones', JSON.stringify(repre));
    $('#obs-representacion').css('display', 'none');
    $('.menu-nav').css({ display: 'flex' });
    $('#content-btnSave').css({ display: 'flex' });
    this.acla.emit(repre.aclaracionesObservaciones);
  }

  repreStatus() {
    this.noEmpleo = this.r.ninguno;
    if (this.noEmpleo) {

      let data = JSON.parse(sessionStorage.getItem('representaciones'));
      data.ninguno = true;
      data.representaciones = null;
      sessionStorage.setItem('representaciones', JSON.stringify(data));
      this.ninguno.emit();
      $("#abrirRepre").css("display", "none");

      //avanza siguiente sección
      setTimeout(() => {
        $("#nextSection").click();
      }, 1000);
    } else {
      let data = JSON.parse(sessionStorage.getItem('representaciones'));
      data.ninguno = null;
      data.representaciones = [];
      sessionStorage.setItem('representaciones', JSON.stringify(data));
      this.ninguno.emit();
      $("#abrirRepre").css("display", "block");
    }
  }

  modificarDatos(data) {
    this.modificar.emit(data);
  }

  eliminarDatos(a, data) {
    console.log(a);
    const id = `#${a.currentTarget.id}`;
    const spanId = `#spanEliminarRe${data.idPosicionVista}`;
    if ($(id).hasClass('confirm')) {
      $(id).addClass('done');
      $(spanId).text('Eliminando');
      this.eliminar.emit(data);
    } else {
      $(id).addClass('confirm');
      $(spanId).text('Confirmar eliminar');
    }
  }

  eliminarMouseout(a, data) {
    const id = `#${a.currentTarget.id}`;
    const spanId = `#spanEliminarRe${data.idPosicionVista}`;
    if ($(id).hasClass('confirm') || $(this).hasClass('done')) {
      setTimeout(() => {
        $(id).removeClass('confirm').removeClass('done');
        $(spanId).text('Eliminar');
      }, 2000);
    }
  }
}