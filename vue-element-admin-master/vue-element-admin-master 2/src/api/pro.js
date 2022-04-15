import request from '@/utils/request'

export function updatePro(params) {
  return request({
    // url: '/vue-element-admin/table/list',
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/updatePro',
    method: 'get',
    data: decodeURI(params)
  })
}
