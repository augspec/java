/*if(/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|ipad|iris|kindle|Android|Silk|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(navigator.userAgent) 
	    || /1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(navigator.userAgent.substr(0,4))) {
	
} else {
	$(".leftBox input").attr("type","hidden");
}
*/

$(document).ready(function() {
	
	var iCheck = checkBrowser();
	
	var licenseKey = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+PExpY2Vuc2UgaWQ9IkwwMDEiPjxUZW5QaGFuTWVtPkJrYXZDQSBTaWduZXIgUGx1Z2luPC9UZW5QaGFuTWVtPjxOZ3VvaUNhcD5Ca2F2IENvcnBvcmF0aW9uPC9OZ3VvaUNhcD48RG9uVmlEdW9jQ2FwPkJrYXYgQ0E8L0RvblZpRHVvY0NhcD48SGFuU3VEdW5nPjxOZ2F5Q2FwPjI4LTAyLTIwMTc8L05nYXlDYXA+PE5nYXlIZXRIYW4+MzEtMTItMjAxNzwvTmdheUhldEhhbj48L0hhblN1RHVuZz48UXV5ZW5TdUR1bmc+PFVuZ0R1bmc+KjwvVW5nRHVuZz48TW9kdWxlWE1MPjE8L01vZHVsZVhNTD48TW9kdWxlUERGPjE8L01vZHVsZVBERj48TW9kdWxlT09YTUw+MTwvTW9kdWxlT09YTUw+PE1vZHVsZUNNUz4xPC9Nb2R1bGVDTVM+PE1vZHVsZUNlcnRpZmljYXRlVXRpbHM+MTwvTW9kdWxlQ2VydGlmaWNhdGVVdGlscz48L1F1eWVuU3VEdW5nPjxTaWduYXR1cmUgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyMiPjxTaWduZWRJbmZvPjxDYW5vbmljYWxpemF0aW9uTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvVFIvMjAwMS9SRUMteG1sLWMxNG4tMjAwMTAzMTUjV2l0aENvbW1lbnRzIi8+PFNpZ25hdHVyZU1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNyc2Etc2hhMSIvPjxSZWZlcmVuY2UgVVJJPSIiPjxUcmFuc2Zvcm1zPjxUcmFuc2Zvcm0gQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjZW52ZWxvcGVkLXNpZ25hdHVyZSIvPjwvVHJhbnNmb3Jtcz48RGlnZXN0TWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI3NoYTEiLz48RGlnZXN0VmFsdWU+MTVoL013N0EzYnNGNVlLTWkrSGxFcE5VNXpzPTwvRGlnZXN0VmFsdWU+PC9SZWZlcmVuY2U+PC9TaWduZWRJbmZvPjxTaWduYXR1cmVWYWx1ZT5WbXhhNDN5R2FzNTh4YW50WjFhR0RsbmtvQitsM2RVUWk1SzErbkd0Q2hnWDJIVUppOE1SbEJCaHNjZU5KeGxJTXRoYmFDTUJaWm0xDQpNM1p3OC9BSmh3citEVGRoV1hjV1ZQQU9hMHNRNEdIdmRFTHdpbzkrQXJtclJ2cVRTZjlNSnROSUlXbVhGd1BZZkdNY1YybzdpQ0htDQpoeW1LeVdhZE0xOExsNDZFaklwS21ldm9QYTVNNW01ZEFLY3JWeDZ2M3JlMm1YcjRiazY0ZlZBZFkzbDVrZXpWYzdzRnc4MHhTMG5TDQp2ZUozblcwTWtuSk5VeUU2QUtJZ0N5MStoTmVCL2Y0UlZjK2lCYTVuOThEN2dmTFIzSnFRVVhlREQ4QzQ0TldkbUFySzQwYjI2Ym42DQpLK1hZdXA5c2pQZ0EvT01lYko4RGw0RUI0T1Bqd0dRbmIxRCtBQT09PC9TaWduYXR1cmVWYWx1ZT48S2V5SW5mbz48WDUwOURhdGE+PFg1MDlTdWJqZWN0TmFtZT5DPVZOLFNUPUjDoCBO4buZaSxMPUPhuqd1IEdp4bqleSxPPUPDtG5nIHR5IEPhu5UgcGjhuqduIEJrYXYsT1U9QmFuIEFOTSxDTj1Ca2F2Q0EgTGljZW5zZSxVSUQ9TVNUOjAxMDEzNjA2OTctQmthdkNBTGljZW5zZTwvWDUwOVN1YmplY3ROYW1lPjxYNTA5Q2VydGlmaWNhdGU+TUlJRXpEQ0NBN1NnQXdJQkFnSVFWQU5EUEJrL0NacG0zcE5kSUJZdWhUQU5CZ2txaGtpRzl3MEJBUVVGQURCSk1Rc3dDUVlEVlFRRw0KRXdKV1RqRU9NQXdHQTFVRUJ4TUZTR0Z1YjJreEdUQVhCZ05WQkFvVEVFSnJZWFlnUTI5eWNHOXlZWFJwYjI0eER6QU5CZ05WQkFNVA0KQmtKcllYWkRRVEFlRncweE5qQTFNekF3TkRBeE1EUmFGdzB4T0RBM01qa3dOREF4TURSYU1JRzFNU3d3S2dZS0NaSW1pWlB5TEdRQg0KQVF3Y1RWTlVPakF4TURFek5qQTJPVGN0UW10aGRrTkJUR2xqWlc1elpURVhNQlVHQTFVRUF3d09RbXRoZGtOQklFeHBZMlZ1YzJVeA0KRURBT0JnTlZCQXNNQjBKaGJpQkJUazB4SWpBZ0JnTlZCQW9NR1VQRHRHNW5JSFI1SUVQaHU1VWdjR2podXFkdUlFSnJZWFl4RlRBVA0KQmdOVkJBY01ERVBodXFkMUlFZHA0YnFsZVRFU01CQUdBMVVFQ0F3SlNNT2dJRTdodTVscE1Rc3dDUVlEVlFRR0V3SldUakNDQVNJdw0KRFFZSktvWklodmNOQVFFQkJRQURnZ0VQQURDQ0FRb0NnZ0VCQUlEblEwQUd5Z2doM0x6SElxcHFBOExSTi9jcE1Ea1dRSWxQNmI4cg0KS0MvQW5HcTRieGF3TkZuRld6NDZ3aTdTVm9MYnI2NUNLZWY4Q0owSUtCbEtEVVlmY1R1VVk2MTRENDRrcTI0b1pNVW9NZnkwQ3ZtZQ0Kd2lPOEw1d0p4eU1zSU0zTjVQMUFVcEVPTkdEN1A3ZG5iUzRBQ3B6RHZkcDFlMGZSOXVTbjV4STc1bThMVGcwRG00VW9DWUtCWk5TVw0KajlINE5vOFduNEYxV0N5UW9xWGNCK1RSZlVWUi83VXBmNGFvczk3Q1VWdmRHd1dsVXV5QnhHK3FNWGk3YWZVd21ZVk1valRYbFFVYQ0KeEFMVEFKam5WLy9hdGtzaEMvejczYmRodlh6NHAwNWMwQ29wVDZQTGF0bERsd0VFMXA1NFZPZlBod2hNVVgzOWRQcmM4enErczBzQw0KQXdFQUFhT0NBVUV3Z2dFOU1ERUdDQ3NHQVFVRkJ3RUJCQ1V3SXpBaEJnZ3JCZ0VGQlFjd0FZWVZhSFIwY0RvdkwyOWpjM0F1WW10aA0KZG1OaExuWnVNQjBHQTFVZERnUVdCQlFqRlkwT3ZoV2prWWNEN25uMnpBdzZBbXZ1NFRBTUJnTlZIUk1CQWY4RUFqQUFNQjhHQTFVZA0KSXdRWU1CYUFGQjZ3RDBpWDM5RERaNmRHaER0WU80Z05VNVNHTUg4R0ExVWRId1I0TUhZd2RLQWpvQ0dHSDJoMGRIQTZMeTlqY213dQ0KWW10aGRtTmhMblp1TDBKcllYWkRRUzVqY215aVRhUkxNRWt4RHpBTkJnTlZCQU1NQmtKcllYWkRRVEVaTUJjR0ExVUVDZ3dRUW10aA0KZGlCRGIzSndiM0poZEdsdmJqRU9NQXdHQTFVRUJ3d0ZTR0Z1YjJreEN6QUpCZ05WQkFZVEFsWk9NQTRHQTFVZER3RUIvd1FFQXdJRg0Kb0RBcEJnTlZIU1VFSWpBZ0JnZ3JCZ0VGQlFjREFRWUlLd1lCQlFVSEF3SUdDaXNHQVFRQmdqY0tBd3d3RFFZSktvWklodmNOQVFFRg0KQlFBRGdnRUJBQy9GSDM1dE8wZHlBVXZwcEJCaWRFOXNUY2EvMkZMK3lCUDFkUFVncHRKVGMwZmJsamU2cS9HanF4SThYckU1K3piZg0KaVBJUTkrd3VIV29VcFBac3RkMUloTlJjQmZXb2JvK1d4RDNLYVhiVWUvSkZDUWpTaGpVTnMzMWNrQVBpMTJSSEs3Uldzazhsdm5HWA0KN0FjUitNeG5uZEVHZjhtZDJYcll3U3d3cGJqYnV0R1J4d3YyZUVMLzZWTUZYbUJjOGZQSytEaW4yNGFTVldPTTlXTlNtWmtYMWJCeg0Ka0lWTDdlYlpKd1p4VDBJSlZiYXg3ZGdFNVdoTW9sa3pZVjR5dStsbFN0aEFrbnBDTkM4TVVxc29kRHNIbWlGWHNTOWwyUGZEYWdYNA0KSDJ6SkJISUhKdG5HKzRBUFh6Rys2WSthMmdoKzMrRWJaTDRscEc2NWtBQnJVbXM9PC9YNTA5Q2VydGlmaWNhdGU+PFg1MDlDZXJ0aWZpY2F0ZT5NSUlFTnpDQ0F4K2dBd0lCQWdJS1lRcnhWQUFBQUFBQUR6QU5CZ2txaGtpRzl3MEJBUVVGQURCK01Rc3dDUVlEVlFRR0V3SldUakV6DQpNREVHQTFVRUNoTXFUV2x1YVhOMGNua2diMllnU1c1bWIzSnRZWFJwYjI0Z1lXNWtJRU52YlcxMWJtbGpZWFJwYjI1ek1Sc3dHUVlEDQpWUVFMRXhKT1lYUnBiMjVoYkNCRFFTQkRaVzUwWlhJeEhUQWJCZ05WQkFNVEZFMUpReUJPWVhScGIyNWhiQ0JTYjI5MElFTkJNQjRYDQpEVEUxTURVeE5UQXpNalUwT0ZvWERUSXdNRFV4TlRBek16VTBPRm93U1RFTE1Ba0dBMVVFQmhNQ1ZrNHhEakFNQmdOVkJBY1RCVWhoDQpibTlwTVJrd0Z3WURWUVFLRXhCQ2EyRjJJRU52Y25CdmNtRjBhVzl1TVE4d0RRWURWUVFERXdaQ2EyRjJRMEV3Z2dFaU1BMEdDU3FHDQpTSWIzRFFFQkFRVUFBNElCRHdBd2dnRUtBb0lCQVFERGpZeTJCem81cjMzdmx3WVRwN3F4V3g0ZHBmcGl6YWY2ZVE2eHpFRFBlUlFODQpqbW1XNi9SRmczZDF0djhrY1NXV3g2S2h1bUlMenpaZHZmRVJYTWtRcFRHdWVxcTM1ekc3ZDlHVWxrbUlWRHljUTRWd3ZveHE5TVRXDQpObnJRc1luL0FScWl4MXVFMFpPc1lueWMzY2NTaTByS1prZ09yeUJHWFVka211ekhPMVhNazhJR04yQUxoZzBJcjBsWStEZENtNHRlDQplYXNiMHNZZGNiVUR3SEpQdGcxa0VKZTFUMm1YU3dZQ05IQnY3TGc3aW5DK0FSZnhvQzBBbGFIYVpVUHpISEJtV3R5SlIyV0h3dVlwDQpETUU0Um04Tkp1MG9mRzdCK05uWmdxMXMyYUdLWG00Y3g0RTk1eFBKbnZLM2U2d25qeGFBNS8zWENaYS9HV1FsQlJJMUFnTUJBQUdqDQpnZXN3Z2Vnd0VnWURWUjBUQVFIL0JBZ3dCZ0VCL3dJQkFEQUxCZ05WSFE4RUJBTUNBWVl3SFFZRFZSME9CQllFRkI2d0QwaVgzOUREDQpaNmRHaER0WU80Z05VNVNHTUI4R0ExVWRJd1FZTUJhQUZNMWljZVJodmY0OTdMSkFZTk9CZGQwNnJHdkdNRHdHQTFVZEh3UTFNRE13DQpNYUF2b0MyR0syaDBkSEE2THk5d2RXSnNhV011Y205dmRHTmhMbWR2ZGk1MmJpOWpjbXd2YldsamJuSmpZUzVqY213d1J3WUlLd1lCDQpCUVVIQVFFRU96QTVNRGNHQ0NzR0FRVUZCekFDaGl0b2RIUndPaTh2Y0hWaWJHbGpMbkp2YjNSallTNW5iM1l1ZG00dlkzSjBMMjFwDQpZMjV5WTJFdVkzSjBNQTBHQ1NxR1NJYjNEUUVCQlFVQUE0SUJBUUJVZVVtdXIra2I4cFpVb3ZpcFNickhUVE4xWGl6UUlYYWtsNG9YDQpaVkZPcHphVE5uU1FXTk5BbzZNY1VORjJOTDFxNHhHZUZjcWJud2MxZFlHamFqcngwU2ZhS28yRmtiaDY1NldieEdUMW1xRS91d2orDQp4cyt6OWRnY3JMK3pTU1QraEdrYXVjdGFBSktMWlRZQWJTSC80VjFlZGRDN2UwYlBJVm81aW5OWVJpdlB5MU1JdXc0TkZHaDlzOG1sDQpuc1A2YmlXMGh0OGVybk14NVlIblFmd2RNK0srYXJ6ZGlKREx6ck5QUmZvN2dTeTUwYzNrSmpmVUZZeGJTZGdUVVhDRERXN240eFk1DQpvdFBOOEJOQ0EyVERiYkhzbWJKWHYzUmE1QjJyZTczNGIwRlBtenoxQmFuWU9hbTJOQW83K3lINzVjSmhZaWVKUjZOc3dzaGRrU3pDPC9YNTA5Q2VydGlmaWNhdGU+PFg1MDlDZXJ0aWZpY2F0ZT5NSUlEMXpDQ0FyK2dBd0lCQWdJUUcrUnppaDgrd0k5SG42YlBOY1dZSWpBTkJna3Foa2lHOXcwQkFRVUZBREIrTVFzd0NRWURWUVFHDQpFd0pXVGpFek1ERUdBMVVFQ2hNcVRXbHVhWE4wY25rZ2IyWWdTVzVtYjNKdFlYUnBiMjRnWVc1a0lFTnZiVzExYm1sallYUnBiMjV6DQpNUnN3R1FZRFZRUUxFeEpPWVhScGIyNWhiQ0JEUVNCRFpXNTBaWEl4SFRBYkJnTlZCQU1URkUxSlF5Qk9ZWFJwYjI1aGJDQlNiMjkwDQpJRU5CTUI0WERUQTRNRFV4TmpBeE1USTBPVm9YRFRRd01EVXhOakF4TWpBek1sb3dmakVMTUFrR0ExVUVCaE1DVms0eE16QXhCZ05WDQpCQW9US2sxcGJtbHpkSEo1SUc5bUlFbHVabTl5YldGMGFXOXVJR0Z1WkNCRGIyMXRkVzVwWTJGMGFXOXVjekViTUJrR0ExVUVDeE1TDQpUbUYwYVc5dVlXd2dRMEVnUTJWdWRHVnlNUjB3R3dZRFZRUURFeFJOU1VNZ1RtRjBhVzl1WVd3Z1VtOXZkQ0JEUVRDQ0FTSXdEUVlKDQpLb1pJaHZjTkFRRUJCUUFEZ2dFUEFEQ0NBUW9DZ2dFQkFLRS9XVkVPL2pEL1lkdVdlQlNMMjBNOE5yNWhyOXkxUDJBZTB3MEJRYTM0DQp5WXBDanNqdE1vWkh4ZjYxOStyV1JEY1FFc05JQ0ZGUXV1Vlg2YzQxeVk0Y2N3bUZNMHpodXppc2pxMjNFd1F1Wm9GWExjejdHdjB1DQpuSXY5Q1VEd1lCZWJjVVZ0ZmVQYkt0SzdtdDNyekY3a0FOL1ZiRENGbTcxWGZ5M1VKTk9BKytBb1ViNncxbUVIek9XZ1IrZVJiUytIDQpXT2kwcmNHeFJyUGNXaDA0Q2RuN3RTZVlubDc4OGZSSS8raWhPLzlRTTlrbXE3S1pZcDNNZThoU1RaNWNRb3R2ZEg3OGxCUGVDdEx3DQp0V3I0bGt4UW5PWWhqc0hsbHdGT3paK3dRQmw4RzFsdlhEZ1ptamZhMFlFNUZqTHZnYTJ3SVdzUmw4TEJDTDF2STF3RUQ5TUNBd0VBDQpBYU5STUU4d0N3WURWUjBQQkFRREFnR0dNQThHQTFVZEV3RUIvd1FGTUFNQkFmOHdIUVlEVlIwT0JCWUVGTTFpY2VSaHZmNDk3TEpBDQpZTk9CZGQwNnJHdkdNQkFHQ1NzR0FRUUJnamNWQVFRREFnRUFNQTBHQ1NxR1NJYjNEUUVCQlFVQUE0SUJBUUJNbmMxK0l5Q0FIQ2pQDQo4UEhKM3hIS3NtbFRvL0pmRExObG5DOVU0UnhRS3VCVkY4UVh2cWlUVVVhcWh1MGtaQzlQRTQ2d3RCU2NmRU8rTFU1alVtemIxbkFYDQpXVWRib2xxeng1WjZ0ZzMxTFEzWlpEcXYwRlE2MFJOb3R2bzREZ1hyNFB3dzkweWJYK0x1WjN2NFl1cDByM0pVVE5UNlhvdnM2N2duDQpnU3lZanZmS29GR1djOFlYaWZuMFU1Yy9WOFBiVlNoSmMwOUtOeXBuaE1VVHZzYko3Z2xIWXIrb3N1cDg1VjhrMnp1NGREV3c0WVdQDQppcGRJanVkNFo0bkw1YVFDN0Z0WG9ibkhscmZCNmVWZGpwbW1weVdhSGJETzFqdHJNL0srU2VFdDFvZUJ1WGF1cC96TnM4WjJNcTlODQpVRkpzTFEyeXZkZFE1ZE4xWTU5ZHpRcVo8L1g1MDlDZXJ0aWZpY2F0ZT48L1g1MDlEYXRhPjwvS2V5SW5mbz48L1NpZ25hdHVyZT48L0xpY2Vuc2U+";	
	var dllName = "bkavcaetoken,bkavcsp,BkavCA,BkavCAv2S";
	var pathFileSignedToDownload =  "";

    var base64ToSign = "";	        
	var certSerial = "";
	var typeSign = "";
	var fileNameExtension = "";
	
	//desktop
	
	document.addEventListener(EXTENSION_EVENT_NAME.SIGN_PDF_BASE64, function (data) {
		$body.removeClass("loading");
	    var result = document.getElementById('hrSignedData').value; // lấy kết quả.
		switch (result) {
			case "Mg==":
				error("Ký không thành công. Dữ liệu pdf đã được ký");
				break;
			case "Mw==":
				error("Ký không thành công. Không tìm thấy cert trong windows store");
				break;
			case "NA==":
				error("Ký không thành công. Dữ liệu xml không đúng chuẩn hoặc không tìm thấy file cần ký");
				break;
			case "NQ==":
				error("Ký không thành công. Lỗi trong quá trình ký.");
				break;
			case "Ng==":
				error("Ký không thành công. Lỗi trong quá trình lưu dữ liệu đã ký.");
				break;
			case "MTM=":
				error("Ký không thành công. Người dùng hủy bỏ nhập mã PIN.");
				break;
			case "Nw==":
				error("Ký không thành công. Người dùng chưa cắm USB Token");
				break;
			case "MA==":
				error("Ký không thành công. Lỗi Plugin");
				break;				
			default:
				console.log(result);
				message("Ký thành công!");		
				download('data:application/pdf;base64,' + result, 'pdf_signed.pdf', 'application/pdf');			
				break;
			}
	});
	
	document.addEventListener(EXTENSION_EVENT_NAME.SIGN_XML_BASE64, function (data) {
		$body.removeClass("loading");
	    var result = document.getElementById('hrSignedData').value; // lấy kết quả.
		switch (result) {
			case "Mg==":
				error("Ký không thành công. Dữ liệu XML đã được ký");
				break;		
			case "Mw==":
				error("Ký không thành công. Không tìm thấy cert trong windows store");
				break;
			case "NA==":
				error("Ký không thành công. Dữ liệu xml không đúng chuẩn hoặc không tìm thấy file cần ký");
				break;
			case "NQ==":
				error("Ký không thành công. Lỗi trong quá trình ký.");
				break;
			case "Ng==":
				error("Ký không thành công. Lỗi trong quá trình lưu dữ liệu đã ký.");
				break;
			case "MTM=":
				error("Ký không thành công. Người dùng hủy bỏ nhập mã PIN.");
				break;
			case "Nw==":
				error("Ký không thành công. Người dùng chưa cắm USB Token");
				break;
			case "MA==":
				error("Ký không thành công. Lỗi Plugin");
				break;				
			default:
				console.log(result);
				message("Ký thành công!");		
				download('data:application/xml;base64,' + result, 'xml_signed.xml', 'application/xml');		
				break;
			}
	});
	
	function signPDFDesktop(serialNumber, base64ToSign) {
	    try {
	        // object PDF
	        var objPdf = new ObjPdfSigner();
	        objPdf.Base64String = base64ToSign; 
	        objPdf.CertificateSerialNumber = serialNumber;
	        // ky voi dau vao Base64
	        objPdf.SigningType = PDF_SIGNING_TYPE.SIGN_PDF_BASE64;
	        BkavExtensionSigner.SetLicenseKey(licenseKey); 
	        if (iCheck == 1) {
	        	// các hàm tương ứng với trình duyệt Chrome
	        	BkavExtensionSigner.SetPINCache(false, false, 0); 
	        	BkavExtensionSigner.SetUsePKCS11(SET_USE_PKCS11.YES);
	        	BkavExtensionSigner.SetDLLName(dllName);
	        	BkavExtensionSigner.SignPDF(objPdf); 
	        }
	        else {
			// các hàm tương ứng với trình duyệt FireFox, IE
	            var result = BkavPluginSigner.SignXML(objPdf);
	        }
	    } catch (e) {
	        alert(e);
	    }
	}
	
	function signXMLDesktop(serialNumber, base64ToSign) {
		
	    try {
	        // object XML
	        var objXml = new ObjXmlSigner();
	        objXml.Base64String = base64ToSign;
	        objXml.CertificateSerialNumber = serialNumber;
	   // ky voi dau vao Base64
	        objXml.SigningType = XML_SIGNING_TYPE.SIGN_XML_BASE64; 
	        BkavExtensionSigner.SetLicenseKey(licenseKey);  
	        // kiêm tra trình duyệt: nếu iCheck = 1 thì trình duyệt đang sử dụng là Chrome 
	        var iCheck = checkBrowser();       // kiểm tra trình duyệt
	        if (iCheck == 1) {
		// các hàm tương ứng với trình duyệt Chrome
        	BkavExtensionSigner.SetPINCache(false, false, 0);
        	BkavExtensionSigner.SetAESKey("TEST"); 
        	BkavExtensionSigner.SetUsePKCS11(SET_USE_PKCS11.YES);
        	BkavExtensionSigner.SetDLLName(dllName);
			BkavExtensionSigner.SignXML(objXml); // doi voi Extension can bat su kien tuong ung de nhan lai ket qua
	        }
	        else {
			// các hàm tương ứng với trình duyệt FireFox, IE
	            var result = BkavPluginSigner.SignXML(objXml);
	        }
	    } catch (e) {
	        alert(e);
	    }
	}
	
	//mobile
	
	$("#btn-confirm-pin").click(function() {
		var pinEtoken = $("#pin-etoken").val();
		if (pinEtoken != "") {
			if (typeSign === "signXMLMobile") {
				signXMLMobile(pinEtoken, certSerial, base64ToSign);
			} 
			
			if (typeSign === "signPDFMobile") {
				signPDFMobile(pinEtoken, certSerial, base64ToSign);
			}
		}

		pinEtoken = "";
	});
	
	$("#btn-cancel-pin").click(function() {
		error("Ký không thành công. Người dùng hủy bỏ nhập mã PIN.");
	});	
	
	function signPDFCallbackMobile(data) {
		
		message("Ký thành công!");
	
		download('data:application/pdf;base64,' + data, 'pdf_signed.pdf', 'application/pdf');
	}
	
	function signPDFMobile(pinEtoken, serial, base64ToSign) {
				  		
		  if (pinEtoken != "") {
			  var objCert = new ObjCertificate();
			  objCert.PIN = pinEtoken;
			  BkavBChromeCA.SignPDF(base64ToSign, objCert, signPDFCallbackMobile);
		  } else {
			  error("Ký không thành công. Sai mã PIN.");
		  }						  			
	}
	
	function SignXMlCallbackMobile(data) {
		
		message("Ký thành công!");
		/*message(Base64.decode(data));	*/
		download('data:application/xml;base64,' + data, 'xml_signed.xml', 'application/xml');
	}
	
	function signXMLMobile(pinEtoken, serial, base64ToSign) {

		  if (pinEtoken != "") {
			  var objCert = new ObjCertificate();
			  objCert.CertificateSerialNumber = serial;
			  objCert.PIN = pinEtoken;
			  BkavBChromeCA.SignXML(base64ToSign, objCert, SignXMlCallbackMobile);
		  } else {
			  error("Ký không thành công. Sai mã PIN.");
		  }
	}
	
	$(".btn-close-popup").click(function() {
		error("Ký không thành công. Người dùng hủy bỏ");
	});	

	$("#select_cert-refresh").click(function(){
		$('#cert_register').modal('hide');
		var serialNumber = $("#select_cert_list").val();
		signAll(serialNumber);
	});
	
	function signAll(certSerial) {
		if(/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|ipad|iris|kindle|Android|Silk|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(navigator.userAgent) 
			    || /1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(navigator.userAgent.substr(0,4))) {
	        switch (fileNameExtension) {
			case "xml":					
				typeSign = "signXMLMobile";
				$("#confirm_modal_pin").modal('show');			  
				break;
			case "pdf":
				typeSign = "signPDFMobile";
				$("#confirm_modal_pin").modal('show');
				break;
			default:
				typeSign = "";
				error("Không hỗ trợ tập tin ." + ext);
				break;
			}
		} else {
			$body.addClass("loading");
	        switch (fileNameExtension) {
			case "xml":
				signXMLDesktop(certSerial, base64ToSign);				  
				break;
			case "pdf":
				signPDFDesktop(certSerial, base64ToSign);
				break;
			default:
				error("Không hỗ trợ tập tin ." + ext);
				break;
			}
		}
	}
	
	$("#file-to-sign").change(function() {
	
	    var files = document.getElementById('file-to-sign').files;
	    
        var filePath = $(this).val();
        $("#name-file-sign").text(filePath.substr(filePath.lastIndexOf('\\') + 1));
        
        fileNameExtension = filePath.substr(filePath.lastIndexOf('.') + 1);
        
	    if (!files.length) {
	      error('Please select a file!');
	      return;
	    }

	    var file = files[0];

	    var reader = new FileReader();

	    // If we use onloadend, we need to check the readyState.
	    reader.onloadend = function(evt) {
	      if (evt.target.readyState == FileReader.DONE) { // DONE == 2
		    var dataO = evt.target.result;
	        console.log(evt.target.result.byteLength);
	        base64ToSign = Base64.base64ArrayBuffer(dataO);	        
			
			$("#label-header-cert-register").text("Chọn chữ ký số để ký tập tin");
			$("#select_cert-refresh").text("Ký tập tin");
			$('#cert_register').modal('show');
	      }
	    };

	    reader.onerror = function(e) {
            console.log(e);
        };
        
	    reader.readAsArrayBuffer(file);
	});

		
});