
(function($){
    $.fn.gbDataGrid = function(opt){
        var defaults = {
            tableCls:"table",
            tableInner:"tableWrap",
            headerDatas:null,
            serviceCall:null,
            returnData:null
        },
        set = $.extend({},defaults,opt);
        
        return this.each(function(){
            var $this = $(this),
                tablewrap = $('<div/>').addClass(set.tableInner),
                tables = $('<table/>').addClass(set.tableCls),
                thead = $('<thead/>'),
                tbdy = $('<tbody/>').addClass('tableBody'),
                selectbxLeftSec = $('<div/>').addClass('selectbxLeftSec'),
                selectRowLabel = $('<div>10</div>').addClass('selectRowLabel'),
                selectboxe = $('<ul/>').addClass('selectbxUl'),
                //search = $('<input type="text" placeholder="Search"/>').addClass('tableSearch'),
                selectbx = $('<select/>').addClass('selectbx'),
                pagenation = $('<div/>').addClass('pagenation'),
                pageNav = $('<div class="pageNav"><span class="prev">Prev</span><span class="currentRecords"></span> of <span class="dataCount"></span> <span class="next">Next</span></div>'),
                headerData = $(set.headerDatas),
                headerTemp="",
                temp="",
                mydata,
                xhr,
                url,
                copydata ={},
                filterData,
                filtercopyData ={},
                dataLength = 10,
                gridData,
                gridDataCopy = {},
                gridDataList =[];
            
                var pageNum;
                var pageShwon = 1;
                var pageLength = 1;
            
            //append
            
            //$this.append(search);
            
            $this.append(tablewrap);
            tablewrap.append(tables);
            tables.append(thead);
            tables.append(tbdy);
            $this.append(selectbxLeftSec);
            selectbxLeftSec.append(selectRowLabel);
            selectbxLeftSec.append(selectboxe);
            //$this.append(selectbx);
            $this.append(pageNav);
            //$this.append(pagenation);
            
            $(tables).attr({
                cellspacing:0,
                cellpadding:0
            });
            
            $(selectbx).html('<option>'+10+'</option>'+'<option>'+20+'</option>'+'<option>'+50+'</option>');
            $(selectboxe).html('<li>'+10+'</li>'+'<li>'+20+'</li>'+'<li>'+50+'</li>');
            
            
            // Table Header Data
            
            headerTemp='<tr>';
            for(var i=0; i < headerData.length; i++){
                headerData[i].isSort = null;
                headerData[i].sortType = 'default';
                headerTemp +='<th class="th column-hd" data-id="'+i+'">'+headerData[i].title+'<span class="sort"><span class="asc"><i class="fa fa-caret-down" aria-hidden="true"></i></span><span  class="dec"><i class="fa fa-caret-up" aria-hidden="true"></i></span></span></th>'
            }
            headerTemp+='</tr>';
            $(thead).html(headerTemp);

            
            //ajax 
            
          /* xhr = new XMLHttpRequest;
           url = set.serviceCall;
            
            xhr.onreadystatechange = function(){
                if(xhr.readyState == 4 && xhr.status == 200){
                    mydata = JSON.parse(xhr.responseText);
                    copydata = [].concat(mydata);
                    templateBuild(mydata);
                }
            }
            
            xhr.open('get',url,true);
            xhr.send();*/
            
            if(set.serviceCall){
               mydata = set.serviceCall;
                    copydata = [].concat(mydata);
                    templateBuild(mydata,dataLength);
                  pageNavFn(mydata);
                
                if(mydata.length > dataLength){
                        pageNum = Math.ceil(mydata.length / dataLength);
                        pageNation(pageNum,mydata);
                    }
                
               }
            $('.countQueue').text((mydata ? mydata.length : "0"));
            $('.selectRowLabel').on('click',function(e){
            	//e.stopPropagation();
            	$('.selectbxUl').slideToggle();
            });
            
            /*$(document).on('click',function(){
            	$('.selectbx').slideUp();
            });*/
            
            $('.selectbxUl li').on('click',function(){
            	$('.selectRowLabel').text($(this).text());      
                dataLength = parseInt($(this).text());
                $('.selectbxUl').slideUp();
                temp='';
                pageNum=0;
                pageShwon = 1;
                pageLength = 1;
                var reclords = (pageLength*dataLength) > mydata.length ? mydata.length: (pageLength*dataLength);
                records = pageShwon+" - "+reclords;
            $this.find('.currentRecords').text(records);
                pageNation(pageNum);
                    if(mydata.length > dataLength){
                        pageNum = Math.ceil(mydata.length / dataLength);
                        pageNation(pageNum,mydata);
                    }
                templateBuild(mydata,dataLength);
                

            });
            
            //table body build
            
            function templateBuild(data,count){
               
                /*
                    
                */
                
                gridDataList = [];
                dataLenLoop(dataLength);
                
                function dataLenLoop(dataLength){
                	$(tbdy).empty();
                    var len = pageShwon-1;
                    for(var i=len; i < count; i++){console.log(data[i]);
                        if(data[i] !== undefined){
                        	temp = "";
                            gridDataList.push(data[i]);console.log(data[i]);
                             temp +='<tr>';
                            for(var y=0; y < headerData.length; y++){
                                if(headerData[y].fieldName == 'Approve'){
                                  temp +='<td class="td btns-td"><button class="deny-btn click" data-id="#light1"><i class="fa fa-times-circle-o" aria-hidden="true"></i></button><button class="approve-btn click" data-id="#light1"><i class="fa fa-check-circle" aria-hidden="true"></i></button></td>';
                                   }else if(headerData[y].fieldName == 'documentName'){
                                      temp +='<td class="td">'+gridDataList[i-len][headerData[y].fieldName]+'</td>';  
                                    }else if(headerData[y].fieldName == 'composedEpubUrl'){
                                        temp +='<td class="td"><i style="display:none;" class="fa fa-link" aria-hidden="true"></i><a class="prevlink" href="'+gridDataList[i-len][headerData[y].fieldName]+'" target="_blank"><img style="width:35px;height:50px;" src="/epub/tmb?imgUrl='+ encodeURIComponent(gridDataList[i-len].thumbnailURL) +'"><span>Preview</span></a></td>';  
                                    }else if(headerData[y].fieldName == 'FileType'){
                                        temp +='<td class="td">'+gridDataList[i-len][headerData[y].fieldName]+'</td>';  
                                    }else {
                                    temp +='<td class="td">'+gridDataList[i-len][headerData[y].fieldName]+'</td>';
                                   }
                                
                            }
                            temp +='</tr>';
                            var ttk = $(temp);
                            ttk.data("row-data", data[i]);
                            $(tbdy).append(ttk); 
                        }
                    }
                };  
            };
            
          //deny 
            $(document).off('click','.deny-btn').on('click','.deny-btn',function(){
        		$(".actionComment").val("");
        		$("#vald-err").text("");
        		$('.sureBx').hide();
        		$('.commentBx').show();
        		//$('.actionLightbx,.selectShadow').show();
        		$(".actApprButton").removeClass("toapprove").removeClass("toreject").addClass("toreject");
        		$(".actApprButton").text("Deny");
        		curtrr = $(this).closest("tr").data("row-data");
        		$('.appdenyTlt').text('Rejection Comment');
        		$('body').gbLightbox({
        			triggerElem : '.click',
        			lightCont : '.lightbox',
        			shadow : '.shadow',
        			closei : 'close'
        		});
        		$(this).trigger("openpopup");
        	});
            
          //approve 
            $(document).off('click','.approve-btn').on('click','.approve-btn',function(){
        		$(".actionComment").val("");
        		$("#vald-err").text("");
        		$('.sureBx').show();
        		$('.commentBx').hide();
        		//$('.actionLightbx,.selectShadow').show();
        		$(".actApprButton").removeClass("toapprove").removeClass("toreject").addClass("toapprove");
        		$(".actApprButton").text("Approve");
        		curtrr = $(this).closest("tr").data("row-data");
        		$('.appdenyTlt').text('Approve Document');
        		$('body').gbLightbox({
        			triggerElem : '.click',
        			lightCont : '.lightbox',
        			shadow : '.shadow',
        			closei : 'close'
        		});
        		$(this).trigger("openpopup");
        	});
            
            //pageNav 
            function pageNavFn(mydata){
                
                var records = pageShwon+" - "+dataLength;
                $this.find('.currentRecords').text(records);
                $this.find('.dataCount').text(mydata.length);
                $this.find('.next').on('click',function(){
                      if(pageLength< pageNum){
                          pageLength+=1;
                          pageShwon +=dataLength;
                       }else{
                           return false;
                       }
                    
                    var reclords = (pageLength*dataLength) > mydata.length ? mydata.length: (pageLength*dataLength);
                        records = pageShwon+" - "+reclords;
                    
                    $this.find('.currentRecords').text(records);
                    templateBuild(mydata,reclords);
                    
                });
               $this.find('.prev').on('click',function(){
                    if(pageLength>1){ 
                      pageLength -=1;
                      pageShwon -=dataLength;
                    }else{
                        pageLength =1;
                        return false;
                    }
                   
                   var reclords = (pageLength*dataLength) > mydata.length ? mydata.length: (pageLength*dataLength);
                        records = pageShwon+" - "+reclords;
                    
                   
                    $this.find('.currentRecords').text(records);
                   
                   
                    templateBuild(mydata,reclords);
                });
            }
            
            //Pagenation
            
                function pageNation(pageNum,data){
                    var pagenationTemp ='';
                    pagenationTemp +='<ul>';
                
                    for(var i=1; i <= pageNum; i++){
                        pagenationTemp +='<li>'+i+'</li>';
                    }
                    pagenationTemp +='</ul>';
                    $(pagenation).html(pagenationTemp);
                    
                    var pageList = $(pagenation).find('li');
                    $(pageList[0]).addClass('active');
                    var tempClick = 0;
                    pageList.each(function(ind,elem){
                        $(elem).on('click',function(){
                            if(pageLength ==(ind+1)){
                            }else{
                                pageLength = ind+1;
                                pageShwon =(dataLength *pageLength)-9;
                            }
                            var reclords = (pageLength*dataLength) > mydata.length ? mydata.length: (pageLength*dataLength);
                                records = pageShwon+" - "+reclords;
                            
                               $this.find('.currentRecords').text(records);
                            
                            
                             templateBuild(mydata,reclords);
                        });
                    });
                    
                };
            
            
            //Seach Field
            
                $(".approveDocs").keyup(function(){
                    var thisVal = $(this).val();
                    
                    if(thisVal !=='' && thisVal !==' ' && thisVal !== 'undefined'){
                        temp ='';
                        function getData(data){
                            for(var i=0; i < headerData.length; i++){
                            	var textVal = typeof data[headerData[i].fieldName] === 'string' ?  data[headerData[i].fieldName].toLowerCase() : data[headerData[i].fieldName]; 
                            	
                            	if((textVal !== null && textVal !== undefined) && textVal.indexOf(thisVal.toLowerCase()) !== -1){
                                    return data;
                                    } 
                            } 
                        }
                        
                        filterData = mydata.filter(getData);
                        filtercopyData = [].concat(copydata)
                        
                    }else {
                         temp ='';
                        filterData = mydata;
                    }
                    
                    count = 10;
                    pageShwon = 1;
                    pageLength = 1;
                    dataLength = 10;
                    var reclords = (pageLength*dataLength) > mydata.length ? mydata.length: (pageLength*dataLength);
                    records = pageShwon+" - "+reclords;
                
               
                $this.find('.currentRecords').text(records);
                    
                    templateBuild(filterData,count);
                    if(filterData.length === 0){
                    	$('.noResults').remove();
            			$('.tableWrap').append('<div class="noResults"><i class="fa fa-filter" aria-hidden="true"></i><h2>Sorry, no results found.</h2> </div>');
            		}else{
            			$('.noResults').remove();
            		}
                })
            
            
            
            //grid Sorting Setting
            gridSortSetting();
            function gridSortSetting(){
                var cellheader = $this.find('.column-hd');
                var currentColumn = {};
                
                $(cellheader).each(function(ind,ele){
                    $(ele).on('click',function(){
                        count = 1;
                        pageShwon = 1;
                        pageLength = 1;
                        dataLength = 10;
                        var reclords = (pageLength*dataLength) > mydata.length ? mydata.length: (pageLength*dataLength);
                        records = pageShwon+" - "+reclords;
                    
                   
                    $this.find('.currentRecords').text(records);
                        
                        $(cellheader).removeClass('active');
                        var ascList =  document.querySelectorAll('.asc');
                       var decList =  document.querySelectorAll('.dec');

                       for(var z=0; z < ascList.length; z++){
                           ascList[z].className='asc'
                       }
                       for(var z=0; z < decList.length; z++){
                           decList[z].className='dec'
                       }
                        var ElemAsc = this.querySelector('.asc');
                        var ElemDsc = this.querySelector('.dec');
                        
                        currentColumn = headerData[ind];
                        
                        if(currentColumn.isSort === null ){
                            currentColumn.isSort = true;
                            currentColumn.sortType = 'asc';
                            ElemAsc.className ='asc';
                            ElemDsc.className ='dec hide';
                            $(this).addClass('active');
                        }
                        else if(currentColumn.isSort === true ){
                            currentColumn.isSort = false;
                            currentColumn.sortType = 'dsc';
                            ElemAsc.className ='asc hide';
                            ElemDsc.className ='dec';
                            $(this).addClass('active');
                        }
                       else if(currentColumn.isSort === false ){
                            currentColumn.isSort = null;
                            currentColumn.sortType = 'default';
                            ElemAsc.className ='asc';
                            ElemDsc.className ='dec';
                           $(cellheader).removeClass('active');
                        }
                        if(filterData){
                            gridSort(currentColumn,filterData,filtercopyData);
                        }/*else if(gridData){
                            gridSort(currentColumn,gridData,gridDataCopy);
                        }*/
                        else{
                            gridSort(currentColumn,mydata,copydata);
                        }
                        
                    })
                    
                })
                
            }
            

            // Sorting
            
            function gridSort(obj,mydatas,copydatas){
                temp='';
                if(obj.fieldName !== 'createdDate'){
                    mydatas.sort(function(a,b){
                    var aVal = a[obj.fieldName] ? a[obj.fieldName].toLowerCase(): a[obj.fieldName];
                    var bVal = b[obj.fieldName] ? b[obj.fieldName].toLowerCase(): b[obj.fieldName];
                     var x = aVal;
                     var y = bVal;

                     if(obj.sortType === 'asc'){
                      if(x > y){
                       return -1;
                      }
                      if(x < y) {
                       return 1;
                      } 
                     }

                     else if(obj.sortType === 'dsc'){

                     if(x < y){
                       return -1;
                      }
                      if(x > y) {
                       return 1;
                      }
                     }

                    });

                   }else{
                  mydatas.sort(function(a,b){
                   var aVal = a[obj.fieldName] ? a[obj.fieldName].toLowerCase(): a[obj.fieldName];
                   var bVal = b[obj.fieldName] ? b[obj.fieldName].toLowerCase(): b[obj.fieldName];
                   
                   var x = new Date(aVal);
                   var y = new Date(bVal);

                   var results;


                   if(obj.sortType === 'asc'){
                      return x < y ? 1 : x > y ? -1 : 0;
                     }

                     else if(obj.sortType === 'dsc'){

                     return x > y ? 1 : x < y ? -1 : 0;
                     }

                  })


                 }
               
               if(obj.sortType !== 'default'){
                   templateBuild(mydatas,dataLength)
               }else{
                 templateBuild(copydatas,dataLength)  
               }
               
            }
            
            
            
        })
    }
})(jQuery)