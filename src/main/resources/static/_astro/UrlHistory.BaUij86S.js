import{h as a,y as c}from"./hooks.module.DxH44NtO.js";import{u as e}from"./jsxRuntime.module.svk5Rx1j.js";import{k as n}from"./preact.module.Bl_WOuGg.js";function h(){const[r,l]=a([]);c(()=>{const t=JSON.parse(localStorage.getItem("urls")||"[]");l(t),console.log(t)},[]);function s(t){const o=document.createElement("textarea");o.value=t,document.body.appendChild(o),o.select(),document.execCommand("copy"),document.body.removeChild(o),console.log("URL copiada al portapapeles")}return e(n,{children:r.length>0&&e("div",{class:"mx-auto w-full max-w-3xl",children:[e("h2",{className:"text-2xl font-semibold text-center md:text-left",children:"URLs Recientes"}),e("div",{className:"mt-3 md:mt-6 space-y-4",children:r.map(t=>e("div",{className:"flex items-center justify-between bg-white shadow-md md:rounded-md p-4",children:[e("div",{className:"grid gap-1",children:[e("div",{className:"text-sm font-medium text-black",children:t.shortUrl}),e("div",{className:"text-sm text-gray-500",children:t.longUrl})]}),e("button",{onClick:()=>s(t.shortUrl),className:"p-2 rounded-md border border-gray-300 hover:bg-gray-100 transition-colors cursor-pointer",children:[e("svg",{xmlns:"http://www.w3.org/2000/svg",fill:"none",viewBox:"0 0 24 24","stroke-width":"1.5",stroke:"currentColor",class:"size-6",children:e("path",{"stroke-linecap":"round","stroke-linejoin":"round",d:"M8.25 7.5V6.108c0-1.135.845-2.098 1.976-2.192.373-.03.748-.057 1.123-.08M15.75 18H18a2.25 2.25 0 0 0 2.25-2.25V6.108c0-1.135-.845-2.098-1.976-2.192a48.424 48.424 0 0 0-1.123-.08M15.75 18.75v-1.875a3.375 3.375 0 0 0-3.375-3.375h-1.5a1.125 1.125 0 0 1-1.125-1.125v-1.5A3.375 3.375 0 0 0 6.375 7.5H5.25m11.9-3.664A2.251 2.251 0 0 0 15 2.25h-1.5a2.251 2.251 0 0 0-2.15 1.586m5.8 0c.065.21.1.433.1.664v.75h-6V4.5c0-.231.035-.454.1-.664M6.75 7.5H4.875c-.621 0-1.125.504-1.125 1.125v12c0 .621.504 1.125 1.125 1.125h9.75c.621 0 1.125-.504 1.125-1.125V16.5a9 9 0 0 0-9-9Z"})}),e("span",{className:"sr-only",children:"Copiar URL"})]})]}))})]})})}export{h as default};
