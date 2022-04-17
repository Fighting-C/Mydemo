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
