(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["about"],{"00b4":function(e,t,a){"use strict";a("ac1f");var o=a("23e7"),n=a("da84"),s=a("c65b"),r=a("e330"),i=a("1626"),d=a("861d"),c=function(){var e=!1,t=/[ac]/;return t.exec=function(){return e=!0,/./.exec.apply(this,arguments)},!0===t.test("abc")&&e}(),u=n.Error,l=r(/./.test);o({target:"RegExp",proto:!0,forced:!c},{test:function(e){var t=this.exec;if(!i(t))return l(this,e);var a=s(t,this,e);if(null!==a&&!d(a))throw new u("RegExp exec method returned something other than an Object or null");return!!a}})},"0b42":function(e,t,a){var o=a("da84"),n=a("e8b5"),s=a("68ee"),r=a("861d"),i=a("b622"),d=i("species"),c=o.Array;e.exports=function(e){var t;return n(e)&&(t=e.constructor,s(t)&&(t===c||n(t.prototype))?t=void 0:r(t)&&(t=t[d],null===t&&(t=void 0))),void 0===t?c:t}},"107c":function(e,t,a){var o=a("d039"),n=a("da84"),s=n.RegExp;e.exports=o((function(){var e=s("(?<a>b)","g");return"b"!==e.exec("b").groups.a||"bc"!=="b".replace(e,"$<a>c")}))},"1dde":function(e,t,a){var o=a("d039"),n=a("b622"),s=a("2d00"),r=n("species");e.exports=function(e){return s>=51||!o((function(){var t=[],a=t.constructor={};return a[r]=function(){return{foo:1}},1!==t[e](Boolean).foo}))}},"3bc0":function(e,t,a){"use strict";a("b2d8")},"3d18":function(e,t,a){},"5c9c":function(e,t,a){"use strict";a.r(t);var o=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"signup"},[a("h1",[e._v("ユーザー新規登録")]),e.usernameerror.length?a("p",[e._v(e._s(e.usernameerror[0]))]):e._e(),e.emailaddresserror.length?a("p",[e._v(e._s(e.emailaddresserror[0]))]):e._e(),e.passworderror.length?a("p",[e._v(e._s(e.passworderror[0]))]):e._e(),a("p",[e._v("ユーザー名：")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.username,expression:"username"}],attrs:{type:"text"},domProps:{value:e.username},on:{input:function(t){t.target.composing||(e.username=t.target.value)}}}),a("p",[e._v("メールアドレス：")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.emailaddress,expression:"emailaddress"}],attrs:{type:"text"},domProps:{value:e.emailaddress},on:{input:function(t){t.target.composing||(e.emailaddress=t.target.value)}}}),a("p",[e._v("パスワード：")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.password,expression:"password"}],attrs:{type:"password"},domProps:{value:e.password},on:{input:function(t){t.target.composing||(e.password=t.target.value)}}}),a("br"),a("button",{on:{click:e.submit}},[e._v("button")])])},n=[],s=(a("a434"),a("ac1f"),a("00b4"),a("d3b7"),a("3ca3"),a("ddb0"),a("9861"),{data:function(){return{username:"",emailaddress:"",password:"",usernameerror:[],passworderror:[],emailaddresserror:[]}},methods:{submit:function(){var e=this;this.passworderror.splice(0,this.passworderror.length),this.usernameerror.splice(0,this.usernameerror.length),this.emailaddresserror.splice(0,this.emailaddresserror.length);var t=/^(?=.*?[a-z])(?=.*?\d)[a-z\d]{8,20}$/i,a=/^[A-Za-z0-9]{1}[A-Za-z0-9_.-]*@{1}[A-Za-z0-9_.-]{1,}.[A-Za-z0-9]{1,}$/;if(""===this.username&&this.usernameerror.push("空白は許可されていません"),t.test(this.password)||this.passworderror.push("パスワードは8文字以上20文字以下で数字小英字を含めてください"),a.test(this.emailaddress)||this.emailaddresserror.push("メールアドレスの形式が違います。"),0==this.usernameerror.length&&0==this.passworderror.length&&0==this.emailaddresserror.length){var o=new URLSearchParams;o.append("emailaddress",this.emailaddress),o.append("password",this.password),o.append("username",this.username),this.axios.post("http://white.source.oysterworld.jp/mytodo/user/signup/activate",o,this.serverPass+"login").then((function(){e.$router.push("signup/activate")})).catch((function(e){console.log(e),window.alert("サインアップに失敗しました。メールアドレスが既に登録されている可能性があります。")}))}}}}),r=s,i=a("2877"),d=Object(i["a"])(r,o,n,!1,null,null,null);t["default"]=d.exports},6311:function(e,t,a){"use strict";a("3d18")},"65f0":function(e,t,a){var o=a("0b42");e.exports=function(e,t){return new(o(e))(0===t?0:t)}},9263:function(e,t,a){"use strict";var o=a("c65b"),n=a("e330"),s=a("577e"),r=a("ad6d"),i=a("9f7f"),d=a("5692"),c=a("7c73"),u=a("69f3").get,l=a("fce3"),p=a("107c"),h=d("native-string-replace",String.prototype.replace),m=RegExp.prototype.exec,v=m,f=n("".charAt),g=n("".indexOf),x=n("".replace),w=n("".slice),b=function(){var e=/a/,t=/b*/g;return o(m,e,"a"),o(m,t,"a"),0!==e.lastIndex||0!==t.lastIndex}(),_=i.BROKEN_CARET,y=void 0!==/()??/.exec("")[1],k=b||y||_||l||p;k&&(v=function(e){var t,a,n,i,d,l,p,k=this,C=u(k),E=s(e),A=C.raw;if(A)return A.lastIndex=k.lastIndex,t=o(v,A,E),k.lastIndex=A.lastIndex,t;var P=C.groups,$=_&&k.sticky,I=o(r,k),R=k.source,U=0,T=E;if($&&(I=x(I,"y",""),-1===g(I,"g")&&(I+="g"),T=w(E,k.lastIndex),k.lastIndex>0&&(!k.multiline||k.multiline&&"\n"!==f(E,k.lastIndex-1))&&(R="(?: "+R+")",T=" "+T,U++),a=new RegExp("^(?:"+R+")",I)),y&&(a=new RegExp("^"+R+"$(?!\\s)",I)),b&&(n=k.lastIndex),i=o(m,$?a:k,T),$?i?(i.input=w(i.input,U),i[0]=w(i[0],U),i.index=k.lastIndex,k.lastIndex+=i[0].length):k.lastIndex=0:b&&i&&(k.lastIndex=k.global?i.index+i[0].length:n),y&&i&&i.length>1&&o(h,i[0],a,(function(){for(d=1;d<arguments.length-2;d++)void 0===arguments[d]&&(i[d]=void 0)})),i&&P)for(i.groups=l=c(null),d=0;d<P.length;d++)p=P[d],l[p[0]]=i[p[1]];return i}),e.exports=v},"9f7f":function(e,t,a){var o=a("d039"),n=a("da84"),s=n.RegExp,r=o((function(){var e=s("a","y");return e.lastIndex=2,null!=e.exec("abcd")})),i=r||o((function(){return!s("a","y").sticky})),d=r||o((function(){var e=s("^r","gy");return e.lastIndex=2,null!=e.exec("str")}));e.exports={BROKEN_CARET:d,MISSED_STICKY:i,UNSUPPORTED_Y:r}},a434:function(e,t,a){"use strict";var o=a("23e7"),n=a("da84"),s=a("23cb"),r=a("5926"),i=a("07fa"),d=a("7b0b"),c=a("65f0"),u=a("8418"),l=a("1dde"),p=l("splice"),h=n.TypeError,m=Math.max,v=Math.min,f=9007199254740991,g="Maximum allowed length exceeded";o({target:"Array",proto:!0,forced:!p},{splice:function(e,t){var a,o,n,l,p,x,w=d(this),b=i(w),_=s(e,b),y=arguments.length;if(0===y?a=o=0:1===y?(a=0,o=b-_):(a=y-2,o=v(m(r(t),0),b-_)),b+a-o>f)throw h(g);for(n=c(w,o),l=0;l<o;l++)p=_+l,p in w&&u(n,l,w[p]);if(n.length=o,a<o){for(l=_;l<b-o;l++)p=l+o,x=l+a,p in w?w[x]=w[p]:delete w[x];for(l=b;l>b-o+a;l--)delete w[l-1]}else if(a>o)for(l=b-o;l>_;l--)p=l+o-1,x=l+a-1,p in w?w[x]=w[p]:delete w[x];for(l=0;l<a;l++)w[l+_]=arguments[l+2];return w.length=b-o+a,n}})},ac1f:function(e,t,a){"use strict";var o=a("23e7"),n=a("9263");o({target:"RegExp",proto:!0,forced:/./.exec!==n},{exec:n})},ad6d:function(e,t,a){"use strict";var o=a("825a");e.exports=function(){var e=o(this),t="";return e.global&&(t+="g"),e.ignoreCase&&(t+="i"),e.multiline&&(t+="m"),e.dotAll&&(t+="s"),e.unicode&&(t+="u"),e.sticky&&(t+="y"),t}},b0c0:function(e,t,a){var o=a("83ab"),n=a("5e77").EXISTS,s=a("e330"),r=a("9bf2").f,i=Function.prototype,d=s(i.toString),c=/function\b(?:\s|\/\*[\S\s]*?\*\/|\/\/[^\n\r]*[\n\r]+)*([^\s(/]*)/,u=s(c.exec),l="name";o&&!n&&r(i,l,{configurable:!0,get:function(){try{return u(c,d(this))[1]}catch(e){return""}}})},b2d8:function(e,t,a){},b972:function(e,t,a){"use strict";a.r(t);var o=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"undone"},[a("router-link",{attrs:{to:"/todo/undone"}},[e._v("まだ")]),e._v(" || "),a("router-link",{attrs:{to:"/todo/done"}},[e._v("終わった")]),a("router-view"),a("h1",[e._v("完了タスク一覧")]),a("button",{on:{click:e.submit}},[e._v("button")]),a("ul",e._l(e.DoneList,(function(t){return a("li",{key:t.todoid},[a("div",{staticClass:"check"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.isChecked,expression:"item.isChecked"}],attrs:{type:"checkbox"},domProps:{checked:Array.isArray(t.isChecked)?e._i(t.isChecked,null)>-1:t.isChecked},on:{change:function(a){var o=t.isChecked,n=a.target,s=!!n.checked;if(Array.isArray(o)){var r=null,i=e._i(o,r);n.checked?i<0&&e.$set(t,"isChecked",o.concat([r])):i>-1&&e.$set(t,"isChecked",o.slice(0,i).concat(o.slice(i+1)))}else e.$set(t,"isChecked",s)}}}),a("div",{class:{complete:t.isChecked}},[e._v(" "+e._s(t.name)+" : "+e._s(t.time)+" : "+e._s(t.date)+" ")])])])})),0)],1)},n=[],s=(a("a434"),a("b0c0"),{data:function(){return{todolist:[],todoid:"",todo:"",name:"",time:"",date:"",updatetime:"",updatedate:"",updatename:""}},created:function(){this.getTodos()},methods:{getTodos:function(){var e=this;this.axios.get("http://white.source.oysterworld.jp/mytodo/todo/read").then((function(t){e.todolist.splice(0,t.data.length),console.log(t);for(var a=0;a<t.data.length;a++){var o=t.data[a].name,n=t.data[a].date,s=t.data[a].time,r=t.data[a].usertododetailsid,i=!0,d=!1,c=t.data[a].time,u=t.data[a].date,l=t.data[a].name;e.todolist.push({name:o,date:n,time:s,todoid:r,isChecked:i,isUpdate:d,updatetime:c,updatedate:u,updatename:l})}console.log(e.todolist)})).catch((function(e){console.log(e)}))},submit:function(){console.log("deleted")}}}),r=s,i=(a("3bc0"),a("2877")),d=Object(i["a"])(r,o,n,!1,null,"1903bf67",null);t["default"]=d.exports},ba52:function(e,t,a){"use strict";a.r(t);var o=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"activate"},[a("h1",[e._v("認証コードを入力してください")]),a("p",[e._v("認証コード：")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.inputactivatecode,expression:"inputactivatecode"}],attrs:{type:"text"},domProps:{value:e.inputactivatecode},on:{input:function(t){t.target.composing||(e.inputactivatecode=t.target.value)}}}),a("button",{on:{click:e.submit}},[e._v("認証開始")])])},n=[],s=(a("d3b7"),a("3ca3"),a("ddb0"),a("9861"),{data:function(){return{inputactivatecode:""}},methods:{submit:function(){var e=this,t=new URLSearchParams;t.append("inputactivatecode",this.inputactivatecode),this.axios.post("http://white.source.oysterworld.jp/mytodo/user/signup",t,this.serverPass+"login").then((function(t){console.log(t.data),window.alert("登録に成功しました。"),e.$router.push("/login")})).catch((function(t){window.alert("サインアップに失敗しました。認証コードが間違っています。"),e.$router.push("/signup"),console.log(t)}))}}}),r=s,i=a("2877"),d=Object(i["a"])(r,o,n,!1,null,null,null);t["default"]=d.exports},c100:function(e,t,a){"use strict";a.r(t);var o=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("a",{attrs:{href:"/"}},[e._v("Go Back to Welcome")])},n=[],s={created:function(){window.alert("ログアウトしました。"),this.axios.get("http://white.source.oysterworld.jp/mytodo/logout")}},r=s,i=a("2877"),d=Object(i["a"])(r,o,n,!1,null,null,null);t["default"]=d.exports},c1f3:function(e,t,a){"use strict";a.r(t);var o=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"undone"},[a("div",{staticClass:"nav"},[a("h1",[e._v("未完了タスク一覧")]),a("p",[e._v("TODOを入力してください")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.todo,expression:"todo"}],attrs:{type:"text"},domProps:{value:e.todo},on:{input:function(t){t.target.composing||(e.todo=t.target.value)}}}),a("button",{on:{click:e.submit}},[e._v("Create!")]),a("button",{on:{click:e.disableTodos}},[e._v("Delete!")]),a("ul",e._l(e.todolist,(function(t){return a("li",{key:t.todoid},[a("div",{staticClass:"check"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.isChecked,expression:"item.isChecked"}],attrs:{type:"checkbox"},domProps:{checked:Array.isArray(t.isChecked)?e._i(t.isChecked,null)>-1:t.isChecked},on:{change:function(a){var o=t.isChecked,n=a.target,s=!!n.checked;if(Array.isArray(o)){var r=null,i=e._i(o,r);n.checked?i<0&&e.$set(t,"isChecked",o.concat([r])):i>-1&&e.$set(t,"isChecked",o.slice(0,i).concat(o.slice(i+1)))}else e.$set(t,"isChecked",s)}}}),a("div",{class:{complete:t.isChecked}},[a("div",{on:{click:function(a){return e.Update(t)}}},[e._v(" "+e._s(t.name)+" : "+e._s(t.time)+" : "+e._s(t.date)+" ")])])]),t.isUpdate?a("input",{directives:[{name:"model",rawName:"v-model",value:t.updatename,expression:"item.updatename"}],attrs:{type:"text"},domProps:{value:t.updatename},on:{input:function(a){a.target.composing||e.$set(t,"updatename",a.target.value)}}}):e._e(),t.isUpdate?a("input",{directives:[{name:"model",rawName:"v-model",value:t.updatetime,expression:"item.updatetime"}],attrs:{type:"time"},domProps:{value:t.updatetime},on:{input:function(a){a.target.composing||e.$set(t,"updatetime",a.target.value)}}}):e._e(),t.isUpdate?a("input",{directives:[{name:"model",rawName:"v-model",value:t.updatedate,expression:"item.updatedate"}],attrs:{type:"date"},domProps:{value:t.updatedate},on:{input:function(a){a.target.composing||e.$set(t,"updatedate",a.target.value)}}}):e._e()])})),0)])])},n=[],s=(a("a434"),a("b0c0"),a("d3b7"),a("3ca3"),a("ddb0"),a("9861"),{data:function(){return{todolist:[],todoid:"",todo:"",name:"",time:"",date:"",isUpdate:!1,isChecked:!1,updatetime:"",updatedate:"",updatename:""}},methods:{getTodos:function(){var e=this;this.todolist.splice(0,this.todolist.length),this.axios.get("http://white.source.oysterworld.jp/mytodo/todo/read").then((function(t){console.log(t);for(var a=0;a<t.data.length;a++){var o=t.data[a].name,n=t.data[a].date,s=t.data[a].time,r=t.data[a].usertododetailsid,i=!1,d=!1,c=t.data[a].time,u=t.data[a].date,l=t.data[a].name;e.todolist.push({name:o,date:n,time:s,todoid:r,isChecked:i,isUpdate:d,updatetime:c,updatedate:u,updatename:l})}console.log(e.todolist)})).catch((function(e){window.alert("読み込みエラー！ログインしていない可能性があります！"),console.log(e)}))},submit:function(){var e=this,t=new URLSearchParams;t.append("todo",this.todo),this.axios.post("http://white.source.oysterworld.jp/mytodo/todo/create",t,this.serverPass+"login").then((function(){e.getTodos()})).catch((function(e){window.alert("ログインに失敗しました。"),console.log(e)}))},disableTodos:function(){for(var e=this,t=[],a=0;a<this.todolist.length;a++)this.todolist[a].isChecked&&t.push(this.todolist[a].todoid);console.log(t);for(var o=new URLSearchParams,n=0;n<t.length;n++){var s=t[n];o.append("deleteId",s)}this.axios.post("http://white.source.oysterworld.jp/mytodo/todo/delete",o,this.serverPass+"login").then((function(){e.getTodos()})).catch((function(e){window.alert("削除失敗"),console.log(e)}))},Update:function(e){if(e.isUpdate){e.isUpdate=!1,e.date=e.updatedate,e.time=e.updatetime,e.name=e.updatename,console.log("updated");var t=new URLSearchParams;t.append("todoid",e.todoid),t.append("name",e.updatename),t.append("date",e.updatedate),t.append("time",e.updatetime),this.axios.post("http://white.source.oysterworld.jp/mytodo/todo/update",t,this.serverPass+"login").then((function(){})).catch((function(e){console.log(e),window.alert("更新失敗")}))}else e.isUpdate=!0}},created:function(){this.getTodos()}}),r=s,i=(a("6311"),a("2877")),d=Object(i["a"])(r,o,n,!1,null,"8a06ba48",null);t["default"]=d.exports},e8b5:function(e,t,a){var o=a("c6b6");e.exports=Array.isArray||function(e){return"Array"==o(e)}},fce3:function(e,t,a){var o=a("d039"),n=a("da84"),s=n.RegExp;e.exports=o((function(){var e=s(".","s");return!(e.dotAll&&e.exec("\n")&&"s"===e.flags)}))}}]);
//# sourceMappingURL=about.f18d0222.js.map