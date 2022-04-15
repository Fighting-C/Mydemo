import request from '@/utils/request'

export function login(data) {
  return request({
    // url: '/vue-element-admin/user/login',
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/login',
    method: 'post',
    params
  })
}

export function getInfo(token) {
  return request({
    // url: '/vue-element-admin/user/info',
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    // url: '/vue-element-admin/user/logout',
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/logout',
    method: 'post'
  })
}
  export function updateUser(params) {
  return request({
    // url: '/vue-element-admin/user/logout',
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/updateUser',
    method: 'get',
    params
  })
}export function deleteUser(params) {
  return request({
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/deleteUser',
    method: 'get',
    params
  })
}
