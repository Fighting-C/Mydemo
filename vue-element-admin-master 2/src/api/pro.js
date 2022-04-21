import request from '@/utils/request'

export function updatePro(params) {
  return request({
    baseURL: 'http://localhost:8080/MyDemo/',
    url: '/updatePro',
    method: 'get',
    params
  })
}
  export function fenHong(params) {
    return request({
      baseURL: 'http://localhost:8080/MyDemo/',
      url: '/fenHong',
      method: 'get',
      params
    })
  }
  export function jieSuan(params) {
    return request({
      baseURL: 'http://localhost:8080/MyDemo/',
      url: '/jieSuan',
      method: 'get',
      params
    })
  }

