let cart = [];

async function loadProducts() {
  try {
    const res = await fetch('/api/products');
    const products = await res.json();
    const grid = document.querySelector('.products-grid');
    grid.innerHTML = products.map(p => `
      <div class="product-card">
        <h3>${p.name}</h3>
        <p>₹${p.price}</p>
        <button class="add-btn" onclick="addToCart(${p.id}, ${p.price}, '${p.name}')">
          Add to Cart
        </button>
      </div>
    `).join('');
  } catch (e) {
    document.querySelector('.products-grid').innerHTML = '<p>Could not load products.</p>';
  }
}

function addToCart(id, price, name) {
  const existing = cart.find(i => i.id === id);
  if (existing) existing.qty++;
  else cart.push({ id, price, name, qty: 1 });
  updateCartDisplay();
}

function updateCartDisplay() {
  const totalItems = cart.reduce((s,i) => s + i.qty, 0);
  const totalPrice = cart.reduce((s,i) => s + i.price * i.qty, 0);
  document.getElementById('cart-count').textContent = totalItems;
  document.getElementById('cart-total').textContent = totalPrice.toFixed(2);
  document.getElementById('order-total').textContent = totalPrice.toFixed(2);
}

document.getElementById('cart-total').onclick = () => {
  document.getElementById('checkout-modal').style.display = 'block';
};

document.querySelector('.close').onclick = () => {
  document.getElementById('checkout-modal').style.display = 'none';
};

document.getElementById('order-form').onsubmit = async e => {
  e.preventDefault();
  const name = document.getElementById('customer-name').value;
  const phone = document
