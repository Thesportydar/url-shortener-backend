import{h as a}from"./hooks.module.DxH44NtO.js";import"./preact.module.Bl_WOuGg.js";import{u as e,C as y}from"./CopyClipboardButton.GB-MTWj-.js";function L(){const[d,c]=a(""),[p,g]=a(""),[n,h]=a(""),[s,u]=a(""),[m,l]=a(""),f=async t=>{t.preventDefault(),l("");const i=JSON.stringify({longUrl:d,alias:s.trim()===""?null:s.trim()});try{const r=await fetch("/api",{method:"POST",headers:{"Content-Type":"application/json"},body:i});if(!r.ok){if(r.status===409){l("La URL personalizada ya está en uso.");return}else if(r.status===400){l("La URL no es válida.");return}else if(r.status===500){l("Error al acortar la URL.");return}}const o=await r.json();h(o.shortUrl),g(o.longUrl),c(""),u(""),x(o.shortUrl,o.longUrl)}catch(r){console.error(r),l("Error al acortar la URL.")}};function x(t,i){let r=JSON.parse(localStorage.getItem("urls")||"[]");r.unshift({longUrl:i,shortUrl:t,date:new Date().toISOString()}),localStorage.setItem("urls",JSON.stringify(r))}return e("div",{class:"mx-auto w-full max-w-3xl space-y-4 sm:space-y-8",children:[e("div",{class:"bg-white p-6 md:rounded-md shadow-md",children:e("form",{class:"flex flex-col gap-4",onSubmit:f,children:[e("input",{type:"url",placeholder:"Pega tu URL aquí...",class:"flex-1 text-lg border rounded-md py-1 px-4 border-gray-300 outline-offset-4 outline-gray-400",value:d,onInput:t=>c(t.target.value),minlength:3,required:!0}),e("div",{class:"flex items-center gap-2",children:[e("div",{className:"flex items-center rounded-lg border border-gray-300 bg-gray-100 px-2 py-2 text-sm text-gray-500",children:"link.inaqui.me/"}),e("input",{type:"text",placeholder:"Personalizá tu URL (opcional)",class:"flex-1 text-sm sm:text-lg border rounded-md py-2 sm:py-1 px-4 border-gray-300 outline-offset-4 outline-gray-400",minlength:6,maxlength:15,value:s,onInput:t=>u(t.target.value)})]}),e("button",{class:"flex py-2 px-8 rounded-md gap-4 bg-gradient-to-r from-purple-600 to-pink-600 text-white text-sm font-bold items-center cursor-pointer justify-center",children:[e("span",{children:"Acortar URL"}),e("svg",{xmlns:"http://www.w3.org/2000/svg",fill:"none",viewBox:"0 0 24 24","stroke-width":"1.5",stroke:"currentColor",class:"size-4",children:e("path",{"stroke-linecap":"round","stroke-linejoin":"round",d:"M13.5 4.5 21 12m0 0-7.5 7.5M21 12H3"})})]})]})}),n&&e("div",{className:"bg-white p-6 md:rounded-md shadow-md space-y-4",children:[e("div",{className:"flex items-center gap-2 text-green-600",children:[e("div",{className:"rounded-full bg-green-100 p-1",children:e("svg",{className:"h-5 w-5",fill:"none",stroke:"currentColor",viewBox:"0 0 24 24",xmlns:"http://www.w3.org/2000/svg",children:e("path",{strokeLinecap:"round",strokeLinejoin:"round",strokeWidth:"2",d:"M5 13l4 4L19 7"})})}),e("p",{className:"font-medium",children:"URL acortada con exito!"})]}),e("div",{className:"space-y-2",children:[e("div",{children:[e("label",{className:"text-sm font-medium text-gray-500",children:"Tu URL acortada"}),e("div",{className:"mt-1 flex items-center gap-2",children:[e("input",{readOnly:!0,value:n,size:25,className:"font-medium p-2 border border-gray-300 rounded-md outline-offset-4 outline-gray-400"}),e(y,{text:n})]})]}),e("div",{className:"space-y-2",children:[e("label",{className:"text-sm font-medium text-gray-500",children:"URL Original"}),e("p",{className:"truncate text-sm text-gray-600",children:p})]})]})]}),m&&e("div",{className:"bg-white p-6 md:rounded-md shadow-md",children:e("div",{className:"flex items-center gap-2 text-red-600",children:[e("div",{className:"rounded-full bg-red-100 p-1",children:e("svg",{className:"h-5 w-5",fill:"none",stroke:"currentColor",viewBox:"0 0 24 24",xmlns:"http://www.w3.org/2000/svg",children:e("path",{strokeLinecap:"round",strokeLinejoin:"round",strokeWidth:"2",d:"M6 18L18 6M6 6l12 12"})})}),e("p",{className:"font-medium",children:[m," Por favor, intenta de nuevo."]})]})})]})}export{L as default};
