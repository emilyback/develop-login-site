<template>
  <div id="app">
    <div v-if="!isloginAdmin">
        ID: <input type="text" v-model="loginId" placeholder="검색어를 입력하세요" autofocus><br>
        PW: <input type="text" v-model="loginPwd" placeholder="검색어를 입력하세요" autofocus><br>
        <button v-on:click="onSubmit">sign Up</button>
    </div>
    <div v-else>
      Welcome Admin
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'app',
  data () {
    return {
      loginParam:{
      loginId : '',
      loginPwd : '',
      },
     
      isloginAdmin : 0
      //msg: 'Welcome to Your Vue.js App'
    }
  },
  methods:{
   onSubmit(){
     //debugger
     /*let params = new URLSearchParams()
     params.append('loginId', this.loginId)
     params.append('loginPwd', this.loginPwd)
    */
     axios.post('/api/LoginCheck',this.loginParam).then(res =>{ //back-end 실행 후 결과 값 = res
      console.log('res', res)
      if(res.data.result === "OK")
        this.isloginAdmin = true
      else
        alert('틀렸어!')

     }).catch((ex) => {
       console.warn("Error")
       alert('error')
      }  
     )}
  }
}
</script>
