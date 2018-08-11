<template>
<el-form :model="ruleForm2"  status-icon :rules="rules2" ref="ruleForm2" label-width="100px"  v-loading="loading" class="demo-ruleForm login-container">
    <h3 class="login_title">用户注册</h3>
   <el-form-item label="用户名" prop="username">
        <el-input type="username" v-model="ruleForm2.username" auto-complete="off"></el-input>
   </el-form-item>
    <el-form-item label="昵称" prop="nickname">
           <el-input type="username" v-model="ruleForm2.nickname" auto-complete="off"></el-input>
    </el-form-item>
   <el-form-item label="密码" prop="password">
     <el-input type="password" v-model="ruleForm2.password" auto-complete="off"></el-input>
   </el-form-item>
   <el-form-item label="确认密码" prop="checkPass">
     <el-input type="password" v-model="ruleForm2.checkPass" auto-complete="off"></el-input>
   </el-form-item>
   <el-form-item label="邮箱" prop="email">
              <el-input type="username" v-model="ruleForm2.email" auto-complete="off"></el-input>
       </el-form-item>
   <el-form-item>
     <el-button type="primary" @click="submitForm('ruleForm2')">提交</el-button>
     <el-button @click="resetForm('ruleForm2')">重置</el-button>
   </el-form-item>
</el-form>
</template>

<script>
 import {postRequest} from '../utils/api'
  import {putRequest} from '../utils/api'
  export default {
    data() {
      var validateUsername=(rule, value, callback)=>{
          if (value === '') {
            callback(new Error('请输入用户名'));}
                    callback();
      };
      var validateNickname=(rule, value, callback)=>{
       if (value === '') {
                  callback(new Error('请输入昵称'));}
       callback();
      };
      var validateEmail=(rule, value, callback)=>{
       if (value === '') {
                callback(new Error('请输入邮箱'));}
       else if (!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(value)){
                 callback(new Error('请输入11邮箱'));}
       callback();
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm2.checkPass !== '') {
            this.$refs.ruleForm2.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm2.password) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      return {
        loading: false,
        ruleForm2: {
          username:'',
          nickname:'',
          email:'',
          password: '',
          checkPass: '',
        },
        rules2: {
          username:[
             { validator: validateUsername, trigger: 'blur' }
          ],
          nickname:[
             { validator: validateNickname, trigger: 'blur' }
          ],
          email:[
             { validator: validateEmail, trigger: 'blur' }
          ],
          password: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPass: [
            { validator: validatePass2, trigger: 'blur' }
          ],
        }
      };
    },
    methods:{
      submitForm(formName) {
        var _this = this;
        _this.$refs[formName].validate((valid) => {
          if (valid) {
          _this.loading=true;
            postRequest('/reg', {
                      username: _this.ruleForm2.username,
                      password: _this.ruleForm2.password,
                      email: _this.ruleForm2.email,
                      nickname: _this.ruleForm2.nickname,
                    }).then(resp=> {
                      _this.loading = false;
                      if (resp.status == 200) {
                        //成功
                        var json = resp.data;
                        if (json.status == 'success') {
                          _this.$router.replace({path: '/'});
                        } else {
                          _this.$alert( json.msg,'注册失败!');
                        }
                      } else {
                        //失败
                        _this.$alert('注册失败!', '失败!');
                      }
                    }, resp=> {
                      _this.loading = false;
                      _this.$alert('找不到服务器⊙﹏⊙∥!', '失败!');
                    });
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>
<style>
 .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
  .login-container {
     border-radius: 15px;
     background-clip: padding-box;
     margin: 180px auto;
     width: 450px;
     padding: 35px 35px 15px 35px;
     background: #fff;
     border: 1px solid #eaeaea;
     box-shadow: 0 0 25px #cac6c6;
   }

  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }

  .login_remember {
    margin: 0px 0px 35px 0px;
    text-align: left;
  }
</style>
