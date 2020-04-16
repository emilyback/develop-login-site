<template>
  <div id="app">
      ID: <input type="text" name="loginId" v-model="loginId"><br/>
      PWD: <input type="password" name="loginPwd" v-model="loginPwd"><br/>
      <button @click="adminCheck(loginId,loginPwd)">log in </button>    
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'app',
  data () {
    return {
      loginId: '',
      loginPwd: '',
      isAdmin: 0
    }
  },
  methods: {
    adminCheck() {
      let params = new URLSearchParams();
      params.append('loginId',this.loginId)
      params.append('loginPwd',this.loginPwd)
      axios.post('/api/AdminCheck',params).then(res => {
        this.isAdmin = res.headers.isadmin
      }).catch((ex) => {
        console.warn('Error')
      })
    }
  }
}
</script>