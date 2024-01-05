<template>
  <div class="login-container">
    <h2>Register</h2>
    <form @submit.prevent="login">
      <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="form.name" required>
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="text" id="password" v-model="form.password" required>
      </div>
      <div class="form-group">
        <label for="phoneNumber">phoneNumber:</label>
        <input type="text" id="phoneNumber" v-model="form.phone" required>
      </div>
      <div class="form-group">
        <label for="Address">Address:</label>
        <input type="text" id="Address" v-model="form.address" required>
      </div>
      <button type="submit">Register</button>
    </form>
  </div>
  <div class = "userInfo">
    <div>{{ userdata.id }}{{ userdata.name }}</div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      

      form: {
					"name": '',
					"password": '',
					"phone":'',
          "address":''
				},
      
      userdata:{
        "id":'',
        "name":'',
      }
    };
  },
  methods: {
    login() {

      axios.post('http://localhost:18081/user/insertUser', this.form)
        .then(function (response) {
          console.log(response);
          if(!response.data){
            this.userdata.id = response.data.id;
            this.userdata.name = response.data.name;
          }
        })
        .catch(function (error) {
          console.log(error);
        });
      // Perform login logic here, e.g., send a request to the server
      console.log('Logging in with:', this.username, this.password);



    }
  }
};
</script>

<style scoped>
.login-container {
  max-width: 300px;
  margin: auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
}

input {
  width: 100%;
  padding: 8px;
  box-sizing: border-box;
  border: 1px solid #ccc;
  border-radius: 3px;
  outline: none;
}

button {
  background-color: #4caf50;
  color: white;
  padding: 10px;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}
</style>
