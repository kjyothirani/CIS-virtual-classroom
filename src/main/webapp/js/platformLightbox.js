(function($){
  $.fn.gbLightbox = function(opt){
    var defaults = {
      triggerElem : '.click',
      lightCont :'.lightbox',
      shadow:'shadow',
      closei:'close'/*,
      opened: function() {
    	  $("#file-7").trigger("click");
      }*/
    },
    set = $.extend({},defaults,opt);

    return this.each(function(){
      /*var $this = $(this),
      focusElem = $this.find(set.triggerElem),
      lightContbox = $this.find(set.lightCont),
      shadowbx = $('<div/>').addClass(set.shadow),
      Ww = $(window).width(),
      Wh = $(window).height(),
      contentHh = Wh - ($(set.lightCont).outerHeight()),
      lightContboxHh = $(set.lightCont).outerHeight(),
      getVal;

      console.log($(lightContboxHh));*/
      
      var $this = $(this),
      focusElem = $this.find(set.triggerElem),
      lightContbox = $this.find(set.lightCont),
      shadowbx = $this.find(set.shadow),
      Ww = $(window).width(),
      Wh = $(window).height(),
      contentHh = Wh - ($(set.lightCont).outerHeight()),
      lightContboxHh = $(set.lightCont).outerHeight(),
      getVal;

      var currentElement = null;
      var curElemWid = null;
      var curElemHih = null;


      init();

      function init(){
        $(set.triggerElem).on('openpopup',function(evt, args){
         /* openLightbox(this);
          responsive();
          $(shadowbx).fadeIn();*/
          
          currentElement = $(this).attr('data-id');
          curElemWid = $(currentElement).outerWidth();
          curElemHih = $(currentElement).outerHeight();
          openLightbox(this);
          responsive(this);
          $(shadowbx).fadeIn();
         /* if (args && args.openfiler && set.opened){
        	  set.opened();
          }*/
        });


        $(document).on('click','.close',function(){
          closeLightbox();
          $('.clsBtn').trigger("click");
        });

        $(set.lightContbox).on('click',function(ev){
          ev.stopPropagation();
        });


        $(shadowbx).on('click',function(){
          closeLightbox();
        });

        $(document).on('keyup',function(evt) {
          if (evt.keyCode == 27) {
            closeLightbox();
          }
        });

		    responsive();
      }

      //init close here

      function openLightbox(_this){
        getVal = $(_this).attr('data-id');
        $(getVal).fadeIn();
      }

      //openLightbox close here

      function responsive(){
        /*Ww = $(window).width();
        Wh = $(window).height();
        contentHh = Wh - 30;		

        $(set.lightCont).css({
			 height:"90%"
          });*/
        
        Ww = $(window).outerWidth();
        Wh = $(window).outerHeight();
        curElemWid = $(currentElement).outerWidth();
        curElemHih = $(currentElement).outerHeight();
        //var roundVal = Math.round($(oldElement).height());
        contentHh = Wh - curElemHih;    

        //console.log(roundVal)
        if(contentHh <0){
           contentHh = 40;
          }
        $(set.lightCont).css({
              top: contentHh / 2,
        left: (Ww - curElemWid)/2
          });

        if($(curElemHih) > Wh){
          $(set.lightCont).css({
            maxHeight:Wh-20,
            height:"100%"
          });
        }else{
          $(set.lightCont).css({
              maxHeight:Wh-20,
              height:"auto",               
          }); 
        }


      }

      //responsive close here

      function closeLightbox(){
        $(shadowbx).fadeOut();
        $(set.lightCont).fadeOut();

      }

      //closeLightbox close here

      $(window).on('resize',function(eve) {
         openLightbox();
         responsive();
          setTimeout(function(){
              responsive();
          },600)
       });
      
      $(document).on('click',function(){
    	  setTimeout(function(){
       	   openLightbox();
              responsive();
          },400);
      });
      
    /*  getResponsive(function(){
           setTimeout(function(){
        	   openLightbox();
               responsive();
           },600);
      })*/

       //resize close here

      // Elements append here

      //$(lightContbox).append(closeIcon);
      //$this.append(shadowbx);
    })

  }
}(jQuery))
