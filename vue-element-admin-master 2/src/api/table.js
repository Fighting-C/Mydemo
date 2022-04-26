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
  export function gettable() {
  return request({
    // url: '/vue-element-admin/table/list',
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/gettable',
    method: 'get',
  })
}
export function getShareList() {
  return request({
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/getShareList',
    method: 'get',
  })
}
export function getOwnShare(params) {
  return request({
    // url: '/vue-element-admin/table/list',
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/getOwnShare',
    method: 'get',
    params
  })
}
export function Add(params) {
  return request({
    // url: '/vue-element-admin/table/list',
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/addOwnShare',
    method: 'get',
    params
  })
}
export function updateShare(params) {
  return request({
    // url: '/vue-element-admin/table/list',
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/updateIndexShare',
    method: 'get',
    params
  })
}
export function deleteshare(params) {
  return request({
    // url: '/vue-element-admin/table/list',
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/deleteshare',
    method: 'get',
    params
  })
}
export function searchList(params) {
  return request({
    // url: '/vue-element-admin/table/list',
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/searchList',
    method: 'get',
    params
  })
}
