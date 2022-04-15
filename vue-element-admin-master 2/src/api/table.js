import request from '@/utils/request'

export function getProList(params) {
  return request({
    // url: '/vue-element-admin/table/list',
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/getAllPro',
    method: 'get',
    params
  })
}

export function getUserList(user) {
  return request({
    // url: '/vue-element-admin/table/list',
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/allUser',
    method: 'get',
    user
  })
}
