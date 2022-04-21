import request from '@/utils/request'

export function getToTask(params) {
  return request({
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/getToTask',
    method: 'get',
    params
  })
}
export function getFromTask(params) {
  return request({
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/getFromTask',
    method: 'get',
    params
  })
}
export function pass(params) {
  return request({
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/pass',
    method: 'get',
    params
  })
}
export function unpass(params) {
  return request({
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/unpass',
    method: 'get',
    params
  })
}
