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
      loginId : '',
      loginPwd : '',
      isloginAdmin : 0
      //msg: 'Welcome to Your Vue.js App'
    }
  },
  methods:{
   onSubmit(){
     //debugger
     let params = new URLSearchParams()
     params.append('loginId', this.loginId)
     params.append('loginPwd', this.loginPwd)

     axios.post('/api/LoginCheck',params).then(res =>{ //back-end 실행 후 결과 값 = res
      this.isloginAdmin = res.headers.isadmin

      console.log(this.isloginAdmin)

     }).catch((ex) => {
       console.warn("Error")
      }
     )}
  }
}
</script>
