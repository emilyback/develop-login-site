<template>
  <div id="app">
    <form method="post" action="/api/NewFile.jsp">
      ID: <input type="text" name="loginId"><br/>
      PWD: <input type="password" name="loginPwd"><br/>
      <input type="submit" value="log in">
    </form>
  </div>
</template>

<script>
export default {
  name: 'app',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>